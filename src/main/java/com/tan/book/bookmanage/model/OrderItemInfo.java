package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单条目表
 * @author tanbb
 */
public class OrderItemInfo implements Serializable {

    //条目id
    private String itemId;

    //订单id
    private String orderId;

    //图书ID
    private String bookId;

    //图书名称
    private String bookName;

    //图书价格
    private double bookPrice;

    //图书数量
    private int bookCount;

    //小计
    private double subTotal;

    //创建时间
    private Date createTime;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
