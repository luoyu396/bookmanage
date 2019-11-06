package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IUserService;
import com.tan.book.bookmanage.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户服务接口实现
 * @author tanbb
 **/
@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractService implements IUserService {

    @Resource(name="userDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean validLogin(String loginName, String password, String userType) {
        return userDao.validLogin(loginName, password, userType);
    }
}
