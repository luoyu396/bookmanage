package com.tan.book.bookmanage.web;

import com.tan.book.bookmanage.model.AjaxResult;

/**
 * 基础控制器接口
 * @author tanbb
 **/
 interface IBaseController<T> {

    /**
     * @Author tanbb
     * @Description 根据参数查询一个数据
     * @Param [params]
     * @return java.lang.String
     **/
     String selectOne(Object params);

    /**
     * @Author tanbb
     * @Description 查询列表
     * @Param []
     * @return AjaxResult
     **/
    AjaxResult queryList();

    /**
     * @Author tanbb
     * @Description 根据页数和记录数查询分页数据
     * @Param [page, rows] 页数和记录数
     * @return AjaxResult
     **/
    AjaxResult queryListPage(int page, int rows);

    /**
     * @Author tanbb
     * @Description 根据页数和记录数查询分页数据
     * @Param [page, rows] 页数和记录数
     * @return AjaxResult
     **/
    AjaxResult queryListPage2(int page, int rows, T params);
}
