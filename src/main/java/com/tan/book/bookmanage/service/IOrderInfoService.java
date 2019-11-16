package com.tan.book.bookmanage.service;

import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.manager.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 订单服务接口
 * @author tanbb
 * @create 2019-11-06 19:14
 */
public interface IOrderInfoService extends IBaseService {
    /**
     * 查询订单与条目集合
     * @param map
     * @return
     */
    List<OrderInfo> orderInfoAndItemList(Map<String,Object> map);
}
