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

    //排序
    private Integer sortNum;

    //用户id
    private String userId;

    //创建时间
    private Date createTime;

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

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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
}
