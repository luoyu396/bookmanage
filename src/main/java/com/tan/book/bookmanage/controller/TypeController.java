package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.ITypeService;
import com.tan.book.bookmanage.model.Type;
import com.tan.book.bookmanage.model.User;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description 图书分类控制器
 * @create 2019-11-06 22:41
 */
@RestController
@RequestMapping("/type")
public class TypeController extends AbstractController<Type> {

    @Resource(name="typeService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private ITypeService typeService;


}
