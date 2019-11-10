package com.tan.book.common.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.common.manager.IBaseService;
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
    public AjaxResult selectOne(@PathVariable("id") Object id) {
        AjaxResult result = new AjaxResult();
        if(id == null) {
            result.put("code", Constants.ERROR);
            result.put("msg", "参数不能为空！" );
            return result;
        }
        try {
            Object object = baseService.selectOne(id);
            result.put("data", object);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @GetMapping("queryList")
    public AjaxResult queryList(T params) {
        AjaxResult result = new AjaxResult();
        try {
            List<T> list = baseService.selectList(params);
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
    //保存前方法
    protected void initSave(T params){}
    /**
     * 保存
     * @param params
     * @return
     */
    @Override
    @PostMapping("save")
    public AjaxResult save(@RequestBody T params) {
        AjaxResult result = new AjaxResult();
        try {
            initSave(params);
            int c = baseService.insert(params);
            if(c > 0) {
                result.put("code", Constants.SUCCESS);
                postSave(params);
            }
            else {
                result.put("code", Constants.ERROR);
                result.put("msg", "保存失败！" );
            }
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
    //保存后方法
    protected void postSave(T params){}
    //更新前方法
    protected void initUpdate(T params){}
    /**
     * 更新
     * @param params
     * @return
     */
    @Override
    @PutMapping("update")
    public AjaxResult update(@RequestBody T params){
        AjaxResult result = new AjaxResult();
        try {
            initUpdate(params);
            int c = baseService.update(params);
            if(c > 0) {
                result.put("code", Constants.SUCCESS);
                postUpdate(params);
            }
            else {
                result.put("code", Constants.ERROR);
                result.put("msg", "更新失败！" );
            }
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
    //更新后方法
    protected void postUpdate(T params){}

    //删除前方法
    protected void initDelete(String params){}
    @Override
    @DeleteMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") String params){
        AjaxResult result = new AjaxResult();
        try {
            initDelete(params);
            int c = baseService.delete(params);
            if(c > 0) {
                result.put("code", Constants.SUCCESS);
                postDelete(params);
            }
            else {
                result.put("code", Constants.ERROR);
                result.put("msg", "删除失败！" );
            }
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
    //删除后方法
    protected void postDelete(String params){}

}
