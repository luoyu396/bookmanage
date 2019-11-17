package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.model.OrderItemInfo;
import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.bookmanage.service.IMyCardService;
import com.tan.book.bookmanage.model.MyCard;
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
 * @description 购物车控制器
 * @create 2019-11-06 22:48
 */
@RestController
@RequestMapping("/myCard")
public class MyCardController extends AbstractController<MyCard> {

    @Resource(name="myCardService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IMyCardService myCardService;

    @Autowired
    private IImageService imageService;

    @Override
    protected void postQueryList(List<MyCard> myCards) {
        myCards.stream().forEach(item -> {
            if(StringUtils.isNotBlank(item.getImgId())) {
                Image image = imageService.selectOne(item.getImgId());
                if(image != null){
                    item.setDownloadUrl(image.getDownloadUrl());
                }
            }
        });
    }

    /**
     * 提交我的的购物车
     * @param myCardList
     * @return
     */
    @PostMapping("submitMyCard")
    public AjaxResult submitMyCard(@RequestBody List<MyCard> myCardList) {
        AjaxResult result = new AjaxResult();
        if(myCardList.isEmpty()) {
            result.put("code", Constants.ERROR);
            result.put("msg", "数据不能为空！" );
            return result;
        }
        try {
           Boolean flag = myCardService.submitMyCard(myCardList);
            result.put("code", flag ? Constants.SUCCESS : Constants.ERROR);
            result.put("msg", flag ? "提交成功" : "提交失败" );
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }
}
