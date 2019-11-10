package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.service.IOrderItemInfoService;
import com.tan.book.bookmanage.model.OrderItemInfo;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description
 * @create 2019-11-06 22:51
 */
@RestController
@RequestMapping("/orderItemInfo")
public class OrderItemInfoController extends AbstractController<OrderItemInfo> {

    @Resource(name="orderItemInfoService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IOrderItemInfoService orderItemInfoService;


}
