package com.tan.book.bookmanage.manager;

import com.tan.book.bookmanage.model.User;
import com.tan.book.bookmanage.service.IBaseService;

/**
 * 用户服务接口
 * @author tanbb
 **/
public interface IUserService extends IBaseService {

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
}
