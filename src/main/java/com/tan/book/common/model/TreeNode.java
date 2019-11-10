package com.tan.book.common.model;

import java.util.List;

/**
 * 分类树形节点对象
 * @author tanbb
 */
public class TreeNode {
	//节点ID
	private String id;
	//节点名称
	private String label;
	//级别
	private Integer leval;
	//父ID
	private String parentId;
	//根ID
	private String rootId;
	//子节点
	private List<TreeNode> children;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}
