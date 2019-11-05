package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IUserService;
import com.tan.book.bookmanage.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author tanbb
 * @Description 用户接口服务实现
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl extends AbstractService implements IUserService {

    @Resource(name="userDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IUserDao userDao;


}
