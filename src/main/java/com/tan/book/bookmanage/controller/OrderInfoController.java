package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.service.IOrderInfoService;
import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description 订单控制器
 * @create 2019-11-06 22:50
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController extends AbstractController<OrderInfo> {

    @Resource(name="orderInfoService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IOrderInfoService orderInfoService;


}
