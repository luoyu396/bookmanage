package com.tan.book.bookmanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.book.bookmanage.model.Book;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.model.OrderItemInfo;
import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.bookmanage.service.IOrderInfoService;
import com.tan.book.bookmanage.model.OrderInfo;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.common.web.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tanbb
 * @description 订单控制器
 * @create 2019-11-06 22:50
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController extends AbstractController<OrderInfo> {

    @Resource(name="orderInfoService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private IImageService imageService;

    /**
     * 查询订单与条目集合
     * @param map
     * @return
     */
    @PostMapping("orderInfoAndItemList")
    public AjaxResult orderInfoAndItemList(@RequestBody Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        try {
            //当前页
            int page = 1;
            //每页大小
            int rows = 10;
            page = map.get("page") != null ? (Integer) map.get("page") : 1;
            rows = map.get("rows") != null ? (Integer) map.get("rows") : 10;
            PageHelper.startPage(page, rows);
            List<OrderInfo> list = orderInfoService.orderInfoAndItemList(map);
            list.stream().forEach(item -> {
                List<OrderItemInfo> orderItemInfoList = item.getOrderItemInfoList();
                if(!orderItemInfoList.isEmpty()) {
                    orderItemInfoList.stream().forEach(itemInfo->{
                        Image image = imageService.selectOne(itemInfo.getImgId());
                        if(image != null){
                            itemInfo.setDownloadUrl(image.getDownloadUrl());
                        }
                    });
                }
            });
            PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(list);
            result.put("data", pageInfo);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
