package com.tan.book.bookmanage.service.impl;

import com.tan.book.bookmanage.business.IBookDao;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.service.IBookService;
import com.tan.book.common.manager.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书信息服务接口实现
 * @author tanbb
 * @create 2019-11-06 17:28
 */
@Service("bookService")
@Transactional
public class BookServiceImpl extends AbstractService implements IBookService {

    @Resource(name="bookDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IBookDao bookDao;


    @Override
    public List<String> selectPublishers() {
        return bookDao.selectPublishers();
    }

    @Override
    public List<String> selectAuthors() {
        return bookDao.selectAuthors();
    }
}
