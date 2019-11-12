package com.tan.book.bookmanage.service;

import com.tan.book.bookmanage.model.StatisticData;
import com.tan.book.common.manager.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 订单条目服务接口
 * @author tanbb
 * @create 2019-11-06 19:45
 */
public interface IOrderItemInfoService extends IBaseService {

    /**
     * 统计图书销量
     * @param map
     * @return
     */
    List<StatisticData> statSaleCountList(Map<String, Object> map);

    /**
     * 统计图书总销量
     * @param map
     * @return
     */
    int statSaleCount(Map<String, Object> map);

    /**
     * 统计图书销售额
     * @param map
     * @return
     */
    List<StatisticData> statSalePriceList(Map<String, Object> map);

    /**
     * 统计图书总销售额
     * @param map
     * @return
     */
    double statSalePrice(Map<String, Object> map);
}
