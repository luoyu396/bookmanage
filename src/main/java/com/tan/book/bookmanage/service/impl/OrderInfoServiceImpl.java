package com.tan.book.bookmanage.service.impl;

import com.tan.book.bookmanage.business.IOrderInfoDao;
import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.service.IOrderInfoService;
import com.tan.book.common.manager.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 订单服务接口明细
 * @author tanbb
 * @create 2019-11-06 19:41
 */
@Service("orderInfoService")
@Transactional
public class OrderInfoServiceImpl extends AbstractService implements IOrderInfoService {

    @Resource(name="orderInfoDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IOrderInfoDao orderInfoDao;


    @Override
    public List<OrderInfo> orderInfoAndItemList(Map<String,Object> map) {
        return orderInfoDao.orderInfoAndItemList(map);
    }
}
