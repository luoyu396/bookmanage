package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IUserService;
import com.tan.book.bookmanage.model.AjaxResult;
import com.tan.book.bookmanage.model.Constants;
import com.tan.book.bookmanage.model.User;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 * @author tanbb
 **/
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User> {

    @Resource(name="userService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IUserService UserService;


    /**
     * 获取当前登录用户信息
     * @param request
     * @return
     */
    @GetMapping("currentUser")
    public AjaxResult getCurrentUser(HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        try {
            HttpSession session = request.getSession();
            if(session.getAttribute("isSuper") != null) {
                boolean isSuper = (boolean) session.getAttribute("isSuper");
                result.put("isSuper", session.getAttribute("isSuper"));
                if(isSuper) {
                    result.put("code", Constants.SUCCESS);
                    return result;
                }
            }
            if(session.getAttribute("user") == null) {
                result.put("code", Constants.ERROR);
                result.put("msg", "会话过期请重新登录！" );
                return result;
            }
            User user = (User) session.getAttribute("user");
            if(user == null) {
                result.put("code", Constants.ERROR);
                result.put("msg", "会话过期请重新登录！" );
                return result;
            }
            result.put("code", Constants.SUCCESS);
            result.put("data", user);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
