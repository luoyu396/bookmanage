package com.tan.book.bookmanage.business;

import com.tan.book.common.dao.IBaseDao;

import java.util.List;

/**
 * 图书信息数据服务接口
 * @author tanbb
 * @create 2019-11-06 17:24
 */
public interface IBookDao extends IBaseDao {

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
