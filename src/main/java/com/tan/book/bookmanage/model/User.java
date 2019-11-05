package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author tanbb
 * @Description 用户表
 * @Version 1.0
 **/
public class User implements Serializable {

    //用户id
    private String userId;

    //登录名
    private String loginName;

    //用户名
    private String userName;

    //用户类型 1：普通用户 2：管理员
    private String userType;

    //密码
    private String password;

    //移动电话
    private String telphone;

    //邮箱
    private String email;

    //地址
    private String address;

    //创建时间
    private Date createTime;

    //备注
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
