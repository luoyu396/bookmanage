package com.tan.book.bookmanage.model;

/**
 * @author tanbb
 * @description 统计数据对象
 * @create 2019-11-10 20:01
 */
public class StatisticData extends Book {

    //销售数量
    private Integer saleCount;

    //销售额
    private Double totalSalePrice;

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Double getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(Double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }
}
