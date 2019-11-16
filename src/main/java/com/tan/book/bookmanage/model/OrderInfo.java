package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 * @author tanbb
 */
public class OrderInfo implements Serializable {

    //订单ID
    private String orderId;

    //订单状态1：已提交 2：配送中 3：已完成 4：已取消
    private String orderStatus;

    //合计金额
    private Double totalMoney;

    //收货地址
    private String address;

    //用户id
    private String userId;

    //用户名
    private String userName;

    //创建时间
    private Date createTime;

    //订单详细
    private List<OrderItemInfo> orderItemInfoList = new ArrayList<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<OrderItemInfo> getOrderItemInfoList() {
        return orderItemInfoList;
    }

    public void setOrderItemInfoList(List<OrderItemInfo> orderItemInfoList) {
        this.orderItemInfoList = orderItemInfoList;
    }
}
