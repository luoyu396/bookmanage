package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.dao.AbstractDao;
import org.springframework.stereotype.Repository;

/**
 * 用户数据接口实现
 * @author tanbb
 **/
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements IUserDao {

}
