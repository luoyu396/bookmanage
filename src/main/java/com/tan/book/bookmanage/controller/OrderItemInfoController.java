package com.tan.book.bookmanage.controller;

import com.github.pagehelper.PageInfo;
import com.tan.book.bookmanage.model.Book;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.service.IBookService;
import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.bookmanage.service.IOrderItemInfoService;
import com.tan.book.bookmanage.model.OrderItemInfo;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Autowired
    private IImageService imageService;

    @Override
    protected void postQueryList(List<OrderItemInfo> orderItemInfos) {
        orderItemInfos.stream().forEach(item -> {
            if(StringUtils.isNotBlank(item.getImgId())) {
                Image image = imageService.selectOne(item.getImgId());
                if(image != null){
                    item.setDownloadUrl(image.getDownloadUrl());
                }
            }
        });
    }
}
