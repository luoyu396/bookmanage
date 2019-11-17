package com.tan.book.bookmanage.service;

import com.tan.book.bookmanage.model.MyCard;
import com.tan.book.common.manager.IBaseService;
import java.util.List;

/**
 * 购物车服务接口
 * @author tanbb
 * @create 2019-11-06 19:09
 */
public interface IMyCardService extends IBaseService {

    /**
     * 提交我的购物车
     * @param myCardList
     * @return
     */
    boolean submitMyCard(List<MyCard> myCardList);
}
