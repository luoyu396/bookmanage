package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.IBookDao;
import com.tan.book.common.dao.AbstractDao;
import org.springframework.stereotype.Repository;

/**
 * 图书信息数据接口实现
 * @author tanbb
 * @create 2019-11-06 17:25
 */
@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements IBookDao {

}
