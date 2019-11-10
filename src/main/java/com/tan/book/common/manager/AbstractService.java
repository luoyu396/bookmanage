package com.tan.book.common.manager;

import com.tan.book.common.dao.IBaseDao;

import java.util.List;

/**
 * 服务接口抽象实现类
 * @author tanbb
 **/
public abstract class AbstractService implements IBaseService {
    public IBaseDao baseDao;
    public abstract void setBaseDao(IBaseDao baseDao);

    public IBaseDao getBaseDao() {
        return baseDao;
    }

    @Override
    public <T> int insert(T params) {
        return baseDao.insert(params);
    }

    @Override
    public <T> int delete(T params) {
        return baseDao.delete(params);
    }

    @Override
    public <T> int update(T params) {
        return baseDao.update(params);
    }

    @Override
    public <T, E> E selectOne(T params) {
        return baseDao.selectOne(params);
    }

    @Override
    public <T, E> List<E> selectList(T params) {
        return baseDao.selectList(params);
    }

    @Override
    public <T> int insert(String id, T params) {
        return baseDao.insert(id,params);
    }

    @Override
    public <T> int delete(String id, T params) {
        return baseDao.delete(id,params);
    }

    @Override
    public <T> int update(String id, T params) {
        return baseDao.update(id,params);
    }

    @Override
    public <T, E> E selectOne(String id, T params) {
        return baseDao.selectOne(id,params);
    }

    @Override
    public <T, E> List<E> selectList(String id, T params) {
        return baseDao.selectList(id,params);
    }

    @Override
    public <T> int insert(String namespace, String id, T params) {
        return baseDao.insert(namespace,id,params);
    }

    @Override
    public <T> int delete(String namespace, String id, T params) {
        return baseDao.delete(namespace,id,params);
    }

    @Override
    public <T> int update(String namespace, String id, T params) {
        return baseDao.update(namespace,id,params);
    }

    @Override
    public <T, E> E selectOne(String namespace, String id, T params) {
        return baseDao.selectOne(namespace,id,params);
    }

    @Override
    public <T, E> List<E> selectList(String namespace, String id, T params) {
        return baseDao.selectList(namespace,id,params);
    }
}
