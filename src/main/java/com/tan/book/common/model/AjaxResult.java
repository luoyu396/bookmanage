package com.tan.book.common.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 操作消息提醒
 * @author tanbb
 */
public class AjaxResult extends HashMap<String, Object> implements Serializable {

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult(){}

    /**
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
