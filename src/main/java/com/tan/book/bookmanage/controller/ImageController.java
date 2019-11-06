package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IImageService;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description 图片附件控制器
 * @create 2019-11-06 22:46
 */
@RestController
@RequestMapping("/image")
public class ImageController extends AbstractController<Image> {

    @Resource(name="imageService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IImageService imageService;


}
