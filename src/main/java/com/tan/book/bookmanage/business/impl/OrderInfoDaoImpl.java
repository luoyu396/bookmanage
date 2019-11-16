package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IOrderInfoDao;
import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.dao.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 订单数据接口实现
 * @author tanbb
 * @create 2019-11-06 19:13
 */
@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends AbstractDao implements IOrderInfoDao {

    @Override
    public List<OrderInfo> orderInfoAndItemList(Map<String,Object> map) {
        return super.getSqlSessionTemplate().selectList(this.getClass().getName()+".orderInfoAndItemList", map);
    }
}
