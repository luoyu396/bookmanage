package com.tan.book.bookmanage.business;

import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.dao.IBaseDao;

import java.util.List;
import java.util.Map;

/**
 * 订单数据接口
 * @author tanbb
 * @create 2019-11-06 19:12
 */
public interface IOrderInfoDao  extends IBaseDao {

    /**
     * 查询订单与条目集合
     * @param map
     * @return
     */
    List<OrderInfo> orderInfoAndItemList(Map<String,Object> map);
}
