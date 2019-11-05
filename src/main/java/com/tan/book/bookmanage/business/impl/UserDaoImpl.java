package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IUserDao;
import com.tan.book.bookmanage.dao.AbstractDao;
import org.springframework.stereotype.Repository;

/**
 * @Author tanbb
 * @Description 用户持久层接口实现
 * @Version 1.0
 **/
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements IUserDao {

}
