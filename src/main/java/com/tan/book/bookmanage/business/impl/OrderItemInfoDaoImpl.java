package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IOrderItemInfoDao;
import com.tan.book.bookmanage.model.StatisticData;
import com.tan.book.bookmanage.model.User;
import com.tan.book.common.dao.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 订单条目数据接口实现
 * @author tanbb
 * @create 2019-11-06 19:44
 */
@Repository("orderItemInfoDao")
public class OrderItemInfoDaoImpl extends AbstractDao implements IOrderItemInfoDao {

    @Override
    public List<StatisticData> statSaleCountList(Map<String, Object> map) {
        return super.getSqlSessionTemplate().selectList(this.getClass().getName()+".statSaleCountList",map);
    }

    @Override
    public List<StatisticData> statSalePriceList(Map<String, Object> map) {
        return super.getSqlSessionTemplate().selectList(this.getClass().getName()+".statSalePriceList",map);
    }
}
