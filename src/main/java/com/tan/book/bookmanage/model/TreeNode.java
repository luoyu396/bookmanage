/** 
 * <p>
 * <br>项目:SalaryManager 
 * <br>文件名:TreeNode.java 
 * <br>包名:com.founder.salary.common.model 
 * <br>创建日期:2017年3月28日下午2:02:18 
 * <br>网址：http://www.founderinternational.com/  
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved  
 * <br>版权所有
 * </p>
 */ 
package com.tan.book.bookmanage.model;

import java.util.List;
import java.util.Map;

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
