package com.tan.book.bookmanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片附件表
 * @author tanbb
 */
public class Image implements Serializable {

    //图片id
    private String imgId;

    //图片名称
    private String imgName;

    //下载路径
    private String downloadUrl;

    //文件大小
    private Integer fileSize;

    //保存路径
    private String fullSavePath;

    //创建时间
    private Date createTime;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFullSavePath() {
        return fullSavePath;
    }

    public void setFullSavePath(String fullSavePath) {
        this.fullSavePath = fullSavePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
