package com.tan.book.bookmanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.model.StatisticData;
import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.bookmanage.service.IOrderItemInfoService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 数据统计控制器
 * @author tanbb
 * @description
 * @create 2019-11-10 0:31
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private IOrderItemInfoService orderItemInfoService;

    @Autowired
    private IImageService imageService;

    @PostMapping("statisticses")
    public AjaxResult statisticsList(@RequestBody Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        //统计类型
        String statisticsType = map.get("statisticsType") == null ? "" : map.get("statisticsType").toString();
        //开始时间
        String startTime = map.get("startTime") == null ? "" : map.get("startTime").toString();
        //结束时间
        String endTime = map.get("endTime") == null ? "" : map.get("endTime").toString();
        //当前页
        int page = 1;
        //每页大小
        int rows = 10;
        page = map.get("page") != null ? (Integer)map.get("page") : 1;
        rows = map.get("rows") != null ? (Integer)map.get("rows") : 10;
        if(StringUtils.isBlank(statisticsType)) {
            result.put("code", Constants.ERROR);
            result.put("msg", "参数不能为空！" );
            return result;
        }
        try {
            List<StatisticData> list = null;
            String totalValue = "总计: ";
            if("1".equals(statisticsType)) {
                PageHelper.startPage(page, rows);
                list = orderItemInfoService.statSaleCountList(map);
                totalValue += orderItemInfoService.statSaleCount(map) + "(本)";
            }
            else {
                PageHelper.startPage(page, rows);
                list = orderItemInfoService.statSalePriceList(map);
                totalValue += orderItemInfoService.statSalePrice(map) + "(元)";
            }
            //获取图片路径
            list.stream().forEach(item->{
                if(StringUtils.isNotBlank(item.getImgId())) {
                    Image image = imageService.selectOne(item.getImgId());
                    if(image != null){
                        item.setDownloadUrl(image.getDownloadUrl());
                    }
                }
            });
            PageInfo<StatisticData> pageInfo = new PageInfo<StatisticData>(list);
            result.put("code", Constants.SUCCESS);
            result.put("data", pageInfo);
            result.put("totalValue", totalValue);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
