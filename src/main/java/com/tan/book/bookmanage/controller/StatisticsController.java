package com.tan.book.bookmanage.controller;

import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("statisticses")
    public AjaxResult statisticsList(@RequestBody Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        //统计类型
        String statisticsType = map.get("statisticsType") == null ? "" : map.get("statisticsType").toString();
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




            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
