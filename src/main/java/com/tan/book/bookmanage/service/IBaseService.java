package com.tan.book.bookmanage.service;

import java.util.List;

/**
 * 基础服务接口
 * @author tanbb
 **/
public interface IBaseService {
    /**
     * @Author tanbb
     * @Description 保存对象
     * @Param [params] 保存对象
     * @return int
     **/
    <T> int insert(T params);

    /**
     * @Author tanbb
     * @Description 删除对象
     * @Param [params] 删除对象
     * @return int
     **/
    <T> int delete(T params);

    /**
     * @Author tanbb
     * @Description 更新对象
     * @Param [params] 更新对象
     * @return int
     **/
    <T> int update(T params);

    /**
     * @Author tanbb
     * @Description 根据对象主键获取对象
     * @Param [params] 主键
     * @return E 返回对象
     **/
    <T, E> E selectOne(T params);

    /**
     * @Author tanbb
     * @Description 根据查询参数查询对象集合
     * @Param [params] 查询参数
     * @return java.util.List<E>
     **/
    <T, E> List<E> selectList(T params);

    /**
     * @Author tanbb
     * @Description 保存对象
     * @Param [id, params] 方法id，保存对象
     * @return int
     **/
    <T> int insert(String id, T params);

    /**
     * @Author tanbb
     * @Description 删除对象
     * @Param [id, params] 方法id，删除对象
     * @return int
     **/
    <T> int delete(String id, T params);

    /**
     * @Author tanbb
     * @Description 更新对象
     * @Param [id, params] 方法id，更新对象
     * @return int
     **/
    <T> int update(String id, T params);

    /**
     * @Author tanbb
     * @Description 根据查询参数获取对象
     * @Param [id, params] 命名空间，方法id，查询参数
     * @return E 返回对象
     **/
    <T, E> E selectOne(String id, T params);

    /**
     * @Author tanbb
     * @Description 根据查询参数查询对象集合
     * @Param [id, params] 方法id，查询参数
     * @return java.util.List<E>
     **/
    <T, E> List<E> selectList(String id, T params);

    /**
     * @Author tanbb
     * @Description 保存对象
     * @Param [namespace, id, params] 命名空间，方法id，保存对象
     * @return int
     **/
    <T> int insert(String namespace, String id, T params);

    /**
     * @Author tanbb
     * @Description 删除对象
     * @Param [namespace, id, params] 命名空间，方法id，删除对象
     * @return int
     **/
    <T> int delete(String namespace, String id, T params);

    /**
     * @Author tanbb
     * @Description 更新对象
     * @Param [namespace, id, params] 命名空间，方法id，更新对象
     * @return int
     **/
    <T> int update(String namespace, String id, T params);

    /**
     * @Author tanbb
     * @Description 根据查询参数获取对象
     * @Param [namespace, id, params] 命名空间，方法id，查询参数
     * @return E 返回对象
     **/
    <T, E> E selectOne(String namespace, String id, T params);

    /**
     * @Author tanbb
     * @Description 根据查询参数查询对象集合
     * @Param [namespace, id, params] 命名空间，方法id，查询参数
     * @return java.util.List<E>
     **/
    <T, E> List<E> selectList(String namespace, String id, T params);
}
