package com.tan.book.bookmanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.bookmanage.service.IBookService;
import com.tan.book.bookmanage.model.Book;
import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.common.web.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author tanbb
 * @description 图书信息控制器
 * @create 2019-11-06 22:44
 */
@RestController
@RequestMapping("/book")
public class BookController extends AbstractController<Book> {

    @Resource(name="bookService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IBookService bookService;

    @Autowired
    private IImageService imageService;

    @Override
    protected void postQueryListPage2(PageInfo<Book> pageInfo) {
        List<Book> list = pageInfo.getList();
        list.stream().forEach(item -> {
            if(StringUtils.isNotBlank(item.getImgId())) {
                Image image = imageService.selectOne(item.getImgId());
                if(image != null){
                    item.setDownloadUrl(image.getDownloadUrl());
                }
            }
        });
    }

    /**
     * 获取出版社
     * @return
     */
    @GetMapping("publishers")
    public AjaxResult selectPublishers() {
        AjaxResult result = new AjaxResult();
        try {
            List<String> list = bookService.selectPublishers();
            result.put("data", list);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取作者
     * @return
     */
    @GetMapping("authors")
    public AjaxResult selectAuthors() {
        AjaxResult result = new AjaxResult();
        try {
            List<String> list = bookService.selectAuthors();
            result.put("data", list);
            result.put("code", Constants.SUCCESS);
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 高级搜索查询图书信息集合
     * @param map
     * @return
     */
    @PostMapping("customBookList")
    public AjaxResult customBookList(@RequestBody Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        try {
            //当前页
            int page = 1;
            //每页大小
            int rows = 10;
            page = map.get("page") != null ? (Integer) map.get("page") : 1;
            rows = map.get("rows") != null ? (Integer) map.get("rows") : 10;
            PageHelper.startPage(page, rows);
            List<Book> list = bookService.customBookList(map);
            list.stream().forEach(item -> {
                if(StringUtils.isNotBlank(item.getImgId())) {
                    Image image = imageService.selectOne(item.getImgId());
                    if(image != null){
                        item.setDownloadUrl(image.getDownloadUrl());
                    }
                }
            });
            PageInfo<Book> pageInfo = new PageInfo<Book>(list);
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
