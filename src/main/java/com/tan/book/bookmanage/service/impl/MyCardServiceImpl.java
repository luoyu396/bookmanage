package com.tan.book.bookmanage.service.impl;

import com.tan.book.bookmanage.business.IMyCardDao;
import com.tan.book.bookmanage.business.IOrderInfoDao;
import com.tan.book.bookmanage.business.IOrderItemInfoDao;
import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.model.MyCard;
import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.bookmanage.model.OrderItemInfo;
import com.tan.book.bookmanage.model.User;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.service.IMyCardService;
import com.tan.book.common.manager.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 购物车服务接口实现
 * @author tanbb
 * @create 2019-11-06 19:10
 */
@Service("myCardService")
@Transactional
public class MyCardServiceImpl extends AbstractService implements IMyCardService {

    @Resource(name="myCardDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IMyCardDao myCardDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IOrderInfoDao orderInfoDao;

    @Autowired
    private IOrderItemInfoDao orderItemInfoDao;
    @Override
    public boolean submitMyCard(List<MyCard> myCardList) {
        if(myCardList.isEmpty()) {
            return false;
        }
        //用户信息
        User user = userDao.selectOne(myCardList.get(0).getUserId());
        //订单编号
        String orderId = new Date().getTime()+"";
        //合计金额
        Double totalMoney = 0.0;
        for (MyCard myCard : myCardList) {
            //订单条目
            OrderItemInfo orderItemInfo = new OrderItemInfo();
            //订单ID
            orderItemInfo.setOrderId(orderId);
            //图书ID
            orderItemInfo.setBookId(myCard.getBookId());
            //图书名称
            orderItemInfo.setBookName(myCard.getBookName());
            //图书价格
            orderItemInfo.setBookPrice(myCard.getBookPrice());
            //图书数量
            orderItemInfo.setBookCount(myCard.getBookCount());
            //小计
            orderItemInfo.setSubTotal(myCard.getBookPrice()*myCard.getBookCount());
            //创建时间
            orderItemInfo.setCreateTime(new Date());
            //保存订单条目
            orderItemInfoDao.insert(orderItemInfo);
            //合计金额
            totalMoney += orderItemInfo.getSubTotal();
            //删除购物车
            myCardDao.delete(myCard.getCardId());
        }
        //订单信息
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);
        //已提交
        orderInfo.setOrderStatus("1");
        //合计金额
        orderInfo.setTotalMoney(totalMoney);
        //地址
        orderInfo.setAddress(user.getAddress());
        //用户ID
        orderInfo.setUserId(user.getUserId());
        orderInfo.setCreateTime(new Date());
        orderInfoDao.insert(orderInfo);


        return true;
    }
}
