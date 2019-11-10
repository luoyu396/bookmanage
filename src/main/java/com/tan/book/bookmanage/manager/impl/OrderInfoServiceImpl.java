package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IOrderInfoDao;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IOrderInfoService;
import com.tan.book.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


}
