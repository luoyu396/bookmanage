package com.tan.book.bookmanage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author tanbb
 * @Description
 * @Version 1.0
 **/
public abstract class AbstractDao implements IBaseDao {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> int insert(T params) {
        return sqlSessionTemplate.insert(this.getClass().getName()+".insert",params);
    }

    @Override
    public <T> int delete(T params) {
        return sqlSessionTemplate.delete(this.getClass().getName()+".delete",params);
    }

    @Override
    public <T> int update(T params) {
        return sqlSessionTemplate.update(this.getClass().getName()+".update",params);
    }

    @Override
    public <T, E> E selectOne(T params) {
        return sqlSessionTemplate.selectOne(this.getClass().getName()+".selectOne",params);
    }

    @Override
    public <T, E> List<E> selectList(T params) {
        return sqlSessionTemplate.selectList(this.getClass().getName()+".selectList",params);
    }

    @Override
    public <T> int insert(String id, T params) {
        return sqlSessionTemplate.insert(this.getClass().getName()+"."+id,params);
    }

    @Override
    public <T> int delete(String id, T params) {
        return sqlSessionTemplate.delete(this.getClass().getName()+"."+id,params);
    }

    @Override
    public <T> int update(String id, T params) {
        return sqlSessionTemplate.update(this.getClass().getName()+"."+id,params);
    }

    @Override
    public <T, E> E selectOne(String id, T params) {
        return sqlSessionTemplate.selectOne(this.getClass().getName()+"."+id,params);
    }

    @Override
    public <T, E> List<E> selectList(String id, T params) {
        return sqlSessionTemplate.selectList(this.getClass().getName()+"."+id,params);
    }

    @Override
    public <T> int insert(String namespace, String id, T params) {
        return sqlSessionTemplate.insert(namespace+"."+id,params);
    }

    @Override
    public <T> int delete(String namespace, String id, T params) {
        return sqlSessionTemplate.delete(namespace+"."+id,params);
    }

    @Override
    public <T> int update(String namespace, String id, T params) {
        return sqlSessionTemplate.update(namespace+"."+id,params);
    }

    @Override
    public <T, E> E selectOne(String namespace, String id, T params) {
        return sqlSessionTemplate.selectOne(namespace+"."+id,params);
    }

    @Override
    public <T, E> List<E> selectList(String namespace, String id, T params) {
        return sqlSessionTemplate.selectList(namespace+"."+id,params);
    }
}
