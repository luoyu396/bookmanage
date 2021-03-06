package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.service.IUserService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.bookmanage.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author tanbb
 * @description 前台用户登录控制器
 * @create 2019-11-06 22:37
 */
@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param loginName 登录名
     * @param password 密码
     * @return
     */
    @PostMapping("login")
    public AjaxResult login(String loginName, String password, HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        if(StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
            result.put("code", Constants.ERROR);
            result.put("msg", "用户名或密码不能为空！" );
            return result;
        }
        try {
            boolean flag = userService.validLogin(loginName, password, "1");
            if(flag) {
                User user = userService.getUser(loginName, password, "1");
                request.getSession().setAttribute("user", user);
            }
            result.put("code", flag ? Constants.SUCCESS : Constants.ERROR);
            result.put("msg", flag ? "登录成功" : "用户名或密码错误" );
            request.getSession().setAttribute("userType", "1");
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("logout")
    public AjaxResult logout(HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

}
