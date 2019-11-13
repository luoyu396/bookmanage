package com.tan.book.bookmanage.service;

import com.tan.book.common.manager.IBaseService;

import java.util.List;

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
}
