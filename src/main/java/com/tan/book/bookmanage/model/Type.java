package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tanbb
 * @description 图书分类表
 */
public class Type implements Serializable {

    //分类ID
    private String typeId;

    //分类名称
    private String typeName;

    //分类级别
    private int leval;

    //父ID
    private String parentId;

    //根ID
    private String rootId;

    //排序
    private int sortNum;

    //创建时间
    private Date createTime;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLeval() {
        return leval;
    }

    public void setLeval(int leval) {
        this.leval = leval;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
