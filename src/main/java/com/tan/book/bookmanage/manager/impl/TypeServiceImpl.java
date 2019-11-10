package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.ITypeDao;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.manager.ITypeService;
import com.tan.book.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 图书分类服务接口实现
 * @author tanbb
 * @create 2019-11-06 17:14
 */
@Service("typeService")
@Transactional
public class TypeServiceImpl extends AbstractService implements ITypeService {

    @Resource(name="typeDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private ITypeDao typeDao;


}
