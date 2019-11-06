package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.dao.AbstractDao;
import com.tan.book.bookmanage.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 用户数据接口实现
 * @author tanbb
 **/
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements IUserDao {

    @Override
    public boolean validLogin(String loginName, String password, String userType) {
        if(StringUtils.isBlank(loginName) || StringUtils.isBlank(password) || StringUtils.isBlank(userType)) {
            return false;
        }
        //用户
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setUserType(userType);
        int count = super.getSqlSessionTemplate().selectOne(this.getClass().getName()+".validLogin",user);
        return count >0 ? true : false;
    }
}
