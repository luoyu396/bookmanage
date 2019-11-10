package com.tan.book.bookmanage.manager.impl;

import com.tan.book.bookmanage.business.IImageDao;
import com.tan.book.common.dao.IBaseDao;
import com.tan.book.bookmanage.manager.IImageService;
import com.tan.book.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 图书附件服务接口实现
 * @author tanbb
 * @create 2019-11-06 17:49
 */
@Service("imageService")
@Transactional
public class ImageServiceImpl extends AbstractService implements IImageService {

    @Resource(name="imageDao")
    public void setBaseDao(IBaseDao baseDao) {
        super.baseDao = baseDao;
    }

    @Autowired
    private IImageDao imageDao;


}
