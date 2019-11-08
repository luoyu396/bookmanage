package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.IBookService;
import com.tan.book.bookmanage.model.Book;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tanbb
 * @description 图书信息控制器
 * @create 2019-11-06 22:44
 */
@RestController
@RequestMapping("/book")
public class BookController extends AbstractController<Book> {

    @Resource(name="bookService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IBookService bookService;


}
