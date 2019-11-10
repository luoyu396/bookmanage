package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IMyCardService;
import com.tan.book.bookmanage.model.MyCard;
import com.tan.book.common.service.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description 购物车控制器
 * @create 2019-11-06 22:48
 */
@RestController
@RequestMapping("/myCard")
public class MyCardController extends AbstractController<MyCard> {

    @Resource(name="myCardService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IMyCardService myCardService;


}
