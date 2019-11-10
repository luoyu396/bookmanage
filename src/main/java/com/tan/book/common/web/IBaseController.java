package com.tan.book.common.web;

import com.tan.book.common.model.AjaxResult;

/**
 * 基础控制器接口
 * @author tanbb
 **/
 interface IBaseController<T> {

    /**
     * @Author tanbb
     * @Description 根据参数查询一个数据
     * @Param [params]
     * @return AjaxResult
     **/
    AjaxResult selectOne(Object params);

    /**
     * @Author tanbb
     * @Description 查询列表
     * @Param []
     * @return AjaxResult
     **/
    AjaxResult queryList(T params);

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

    /**
     * 保存
     * @param params
     * @return
     */
    AjaxResult save(T params);

    /**
     * 更新
     * @param params
     * @return
     */
    AjaxResult update(T params);

   /**
    * 删除
    * @param id
    * @return
    */
    AjaxResult delete(String id);
}
