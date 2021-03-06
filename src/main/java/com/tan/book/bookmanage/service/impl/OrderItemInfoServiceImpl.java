package com.tan.book.bookmanage.service.impl;

import com.tan.book.bookmanage.business.IOrderItemInfoDao;
import com.tan.book.bookmanage.model.StatisticData;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.service.IOrderItemInfoService;
import com.tan.book.common.manager.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 订单条目服务接口实现
 * @author tanbb
 * @create 2019-11-06 19:45
 */
@Service("orderItemInfoService")
@Transactional
public class OrderItemInfoServiceImpl extends AbstractService implements IOrderItemInfoService {

    @Resource(name="orderItemInfoDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IOrderItemInfoDao orderItemInfoDao;


    @Override
    public List<StatisticData> statSaleCountList(Map<String, Object> map) {
        return orderItemInfoDao.statSaleCountList(map);
    }

    @Override
    public int statSaleCount(Map<String, Object> map) {
        return orderItemInfoDao.statSaleCount(map);
    }

    @Override
    public List<StatisticData> statSalePriceList(Map<String, Object> map) {
        return orderItemInfoDao.statSalePriceList(map);
    }

    @Override
    public double statSalePrice(Map<String, Object> map) {
        return orderItemInfoDao.statSalePrice(map);
    }
}
