package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IUserService;
import com.tan.book.bookmanage.model.User;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 * @author tanbb
 **/
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController extends AbstractController<User> {

    @Override
    @Resource(name="userService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IUserService UserService;


}
