package com.tan.book.bookmanage.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.tan.book.bookmanage.service.IBaseService;
import org.springframework.web.bind.annotation.*;

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
    public String queryList() {
        return JSON.toJSONString(baseService.selectList(null));
    }

    @Override
    @GetMapping("queryListPage")
    public String queryListPage(int page,int rows){
        PageHelper.startPage(page, rows);
        return JSON.toJSONString(baseService.selectList(null));
    }

    @Override
    @PostMapping("queryListPage2")
    public String queryListPage2(int page, int rows, T params) {
        PageHelper.startPage(page, rows);
        return JSON.toJSONString(baseService.selectList(params));
    }
}
