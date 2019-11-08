package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.manager.ITypeService;
import com.tan.book.bookmanage.model.*;
import com.tan.book.bookmanage.service.IBaseService;
import com.tan.book.bookmanage.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanbb
 * @description 图书分类控制器
 * @create 2019-11-06 22:41
 */
@RestController
@RequestMapping("/type")
public class TypeController extends AbstractController<Type> {

    @Resource(name="typeService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private ITypeService typeService;

    /**
     * 获取分类树形节点
     * @return
     */
    @GetMapping("treeNodes")
    public AjaxResult treeNodeList() {
        AjaxResult result = new AjaxResult();
        try {
            //分类集合
            List<Type> typeList = typeService.selectList(null);
            //获取树形节点
            List<TreeNode> nodeList = new ArrayList<>();
            if(!typeList.isEmpty()) {
                nodeList = Type.getTreeNode(typeList);
            }
            result.put("code", Constants.SUCCESS);
            result.put("data", nodeList);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }


}
