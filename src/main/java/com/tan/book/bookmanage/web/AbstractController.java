package com.tan.book.bookmanage.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.book.bookmanage.model.AjaxResult;
import com.tan.book.bookmanage.model.Constants;
import com.tan.book.bookmanage.service.IBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础控制器接口抽象实现类
 * @author tanbb
 **/
public abstract class AbstractController<T> implements IBaseController<T>{
    public IBaseService baseService;
    public IBaseService getBaseService() {
        return baseService;
    }
    public abstract void setBaseService(IBaseService baseService);

    @Override
    @GetMapping("selectOne/{id}")
    public String selectOne(@PathVariable("id") Object id) {
        return JSON.toJSONString(baseService.selectOne(id));
    }

    @Override
    @GetMapping("queryList")
    public AjaxResult queryList() {
        AjaxResult result = new AjaxResult();
        try {
            List<T> list = baseService.selectList(null);
            result.put("data", list);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @GetMapping("queryListPage")
    public AjaxResult queryListPage(int page, int rows){
        AjaxResult result = new AjaxResult();
        try {
            PageHelper.startPage(page, rows);
            List<T> list = baseService.selectList(null);
            PageInfo<T> pageInfo = new PageInfo<T>(list);
            result.put("data", pageInfo);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @PostMapping("queryListPage2")
    public AjaxResult queryListPage2(int page, int rows, T params) {
        AjaxResult result = new AjaxResult();
        try {
            PageHelper.startPage(page, rows);
            List<T> list = baseService.selectList(params);
            PageInfo<T> pageInfo = new PageInfo<T>(list);
            result.put("data", pageInfo);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
