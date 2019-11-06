package com.tan.book.bookmanage.business.impl;

import com.tan.book.bookmanage.business.ITypeDao;
import com.tan.book.bookmanage.dao.AbstractDao;
import org.springframework.stereotype.Repository;

/**
 * 图书分类数据接口实现
 * @author tanbb
 */
@Repository("typeDao")
public class TypeDaoImpl extends AbstractDao implements ITypeDao {

}
