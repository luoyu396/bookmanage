package com.tan.book.bookmanage.service;

import com.tan.book.bookmanage.model.Book;
import com.tan.book.common.manager.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 图书信息服务接口
 * @author tanbb
 * @create 2019-11-06 17:26
 */
public interface IBookService extends IBaseService {

    /**
     * 查询所有出版社
     * @return
     */
    List<String> selectPublishers();

    /**
     * 查询所有作者
     * @return
     */
    List<String> selectAuthors();

    /**
     * 高级搜索查询图书信息集合
     * @param map
     * @return
     */
    List<Book> customBookList(Map<String,Object> map);
}
