package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.service.IUserService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.bookmanage.model.User;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private IUserService userService;

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

    /**
     * 更新密码
     * @param userId 用户ID
     * @param password 密码
     * @return
     */
    @PutMapping("updatePassword")
    public AjaxResult updatePassword(String userId, String password){
        AjaxResult result = new AjaxResult();
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(password)) {
            result.put("code", Constants.ERROR);
            result.put("msg", "参数不能为空！" );
            return result;
        }
        try {
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);
            boolean flag = userService.updatePassword(user);
            if(flag) {
                result.put("code", Constants.SUCCESS);
            }
            else {
                result.put("code", Constants.ERROR);
                result.put("msg", "更新失败！" );
            }
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新当前会话用户信息
     * @param request
     * @return
     */
    @GetMapping("updateSessionUser/{userId}")
    public AjaxResult updateSessionUser(@PathVariable("userId") String userId, HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        try {
            HttpSession session = request.getSession();
            User user = userService.selectOne(userId);
            if(user == null) {
                result.put("code", Constants.ERROR);
                result.put("msg", "用户不存在！" );
                return result;
            }
            request.getSession().setAttribute("user", user);
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
