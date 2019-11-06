package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IMyCardDao;
import com.tan.book.bookmanage.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IMyCardService;
import com.tan.book.bookmanage.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


}
