package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IUserService;
import com.tan.book.bookmanage.model.AjaxResult;
import com.tan.book.bookmanage.model.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tanbb
 * @description 后台管理用户登录控制器
 * @create 2019-11-06 22:40
 */
@RestController
@RequestMapping("/adminLogin")
public class AdminLoginController {

    @Autowired
    private IUserService userService;

    @Value("${super.loginName}")
    private String superLoginName;

    @Value("${super.password}")
    private String superPassword;

    /**
     * 管理员登录
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
            //是否超级账号
            if(StringUtils.isNotBlank(superLoginName) && StringUtils.isNotBlank(superPassword)
                    && superLoginName.equals(loginName) && superPassword.equals(password)){
                result.put("code", Constants.SUCCESS);
                result.put("msg", "登录成功！" );
                request.getSession().setAttribute("isSuper", true);
                return result;
            }
            boolean flag = userService.validLogin(loginName, password, "2");
            result.put("code", flag ? Constants.SUCCESS : Constants.ERROR);
            result.put("msg", flag ? "登录成功" : "用户名或密码错误" );
            request.getSession().setAttribute("isSuper", false);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
