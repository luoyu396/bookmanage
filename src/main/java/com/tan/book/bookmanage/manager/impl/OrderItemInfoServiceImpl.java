package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IOrderItemInfoDao;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IOrderItemInfoService;
import com.tan.book.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


}
