package com.tan.book.bookmanage.business;

import com.tan.book.bookmanage.dao.IBaseDao;
import com.tan.book.bookmanage.model.User;

/**
 * 用户数据接口
 * @author tanbb
 **/
public interface IUserDao extends IBaseDao {

    /**
     * 验证登录
     * @param loginName 登录名
     * @param password 密码
     * @param userType 用户类型 1：普通用户 2：管理员
     * @return
     */
    boolean validLogin(String loginName, String password, String userType);

    /**
     * 查询用户
     * @param loginName 登录名
     * @param password 密码
     * @param userType 用户类型 1：普通用户 2：管理员
     * @return
     */
    User getUser(String loginName, String password, String userType);

    /**
     * 更新密码
     * @param user 用户表
     * @return
     */
    boolean updatePassword(User user);
}
