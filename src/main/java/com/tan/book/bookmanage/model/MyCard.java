package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车表
 * @author tanbb
 */
public class MyCard implements Serializable {

    //购物车ID
    private String cardId;

    //图书ID
    private String bookId;

    //图书数量
    private Integer bookCount;

    //用户id
    private String userId;

    //创建时间
    private Date createTime;

    //图书名称
    private String bookName;

    //图书价格
    private Double bookPrice;

    //图片id
    private String imgId;

    //下载路径
    private String downloadUrl;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
