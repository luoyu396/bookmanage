package com.tan.book.bookmanage.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * 图书分类表
 * @author tanbb
 */
public class Type implements Serializable {

    //分类ID
    private String typeId;

    //分类名称
    private String typeName;

    //分类级别
    private Integer leval;

    //父ID
    private String parentId;

    //根ID
    private String rootId;

    //排序
    private Integer sortNum;

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

    public Integer getLeval() {
        return leval;
    }

    public void setLeval(Integer leval) {
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

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 分类集合转换树形节点
     * @param typeList 分类集合
     * @return
     */
    public static List<TreeNode> getTreeNode(List<Type> typeList){
        List<TreeNode> nodeList = new ArrayList<>();
        if(typeList != null && !typeList.isEmpty()){
            for(Type type : typeList){
                TreeNode treeNode = new TreeNode();
                //判断是否是根节点，根节点父ID为空
                if(StringUtils.isBlank(type.getParentId())){
                    //设置节点ID
                    treeNode.setId(type.getTypeId());
                    //设置节点显示名称
                    treeNode.setLabel(type.getTypeName());
                    //级别
                    treeNode.setLeval(type.getLeval());
                    //父ID
                    treeNode.setParentId(type.getParentId());
                    //根ID
                    treeNode.setRootId(type.getRootId());
                    //获取子节点
                    List<TreeNode> treeNodeList = getChildrenTreeNode(typeList,type.getTypeId());
                    if(treeNodeList != null && !treeNodeList.isEmpty()){
                        treeNode.setChildren(treeNodeList);
                    }
                    nodeList.add(treeNode);
                }
            }
        }
        return nodeList;
    }
    /**
     * 递归获取子集合
     * @param typeList 分类集合
     * @param parentId 父ID
     * @return
     */
    private static List<TreeNode> getChildrenTreeNode(List<Type> typeList,String parentId){
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        if(typeList != null && !typeList.isEmpty()){
            for(Type type : typeList){
                if(StringUtils.isNotBlank(type.getParentId()) && type.getParentId().equals(parentId)){
                    TreeNode treeNode = new TreeNode();
                    //设置节点ID
                    treeNode.setId(type.getTypeId());
                    //设置节点显示名称
                    treeNode.setLabel(type.getTypeName());
                    //级别
                    treeNode.setLeval(type.getLeval());
                    //父ID
                    treeNode.setParentId(type.getParentId());
                    //根ID
                    treeNode.setRootId(type.getRootId());
                    //获取子节点
                    List<TreeNode> childTreeNodeList = getChildrenTreeNode(typeList,type.getTypeId());
                    if(childTreeNodeList != null && !childTreeNodeList.isEmpty()){
                        treeNode.setChildren(childTreeNodeList);
                    }
                    treeNodeList.add(treeNode);
                }
            }
        }
        return treeNodeList;
    }
}
