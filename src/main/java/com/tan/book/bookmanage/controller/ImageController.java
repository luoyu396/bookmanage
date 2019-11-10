package com.tan.book.bookmanage.controller;

import com.tan.book.bookmanage.service.IImageService;
import com.tan.book.common.model.AjaxResult;
import com.tan.book.common.model.Constants;
import com.tan.book.bookmanage.model.Image;
import com.tan.book.common.manager.IBaseService;
import com.tan.book.common.web.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author tanbb
 * @description 图片附件控制器
 * @create 2019-11-06 22:46
 */
@RestController
@RequestMapping("/image")
public class ImageController extends AbstractController<Image> {

    @Value("${bookimg.upload}")
    private String uploadPath;

    @Resource(name="imageService")
    public void setBaseService(IBaseService baseService) {
        super.baseService = baseService;
    }

    @Autowired
    private IImageService imageService;


    @PostMapping("upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        try {
            //文件名
            String fileFileName = file.getOriginalFilename();
            //文件大小
            Long fileSize = file.getSize();
            //目标文件名
            int pos = -1;
            String extName = "";
            if (StringUtils.isNotEmpty(fileFileName)) {
                pos = fileFileName.lastIndexOf(".");
            }
            if (pos != -1) {
                extName = fileFileName.substring(pos);
            }
            String filenamePrefix = UUID.randomUUID().toString().replace("-", "");
            String filename = filenamePrefix + extName;
            //保存路径目录
            File fileRoot = new File(uploadPath);
            if(fileRoot.getParentFile().isDirectory()){//判断上级目录是否是目录
                if(!fileRoot.exists()){   //如果文件目录不存在
                    fileRoot.mkdirs();  //创建文件目录
                }
            }
            //目标文件全路径
            String targetFilePath = uploadPath + filename;
            File targetFile = new File(targetFilePath);
            // 拷贝文件
            BufferedInputStream bufferIn = null;
            OutputStream out = null;
            InputStream fileIns = null;
            try {
                fileIns = file.getInputStream();
                bufferIn = new BufferedInputStream(fileIns);
                out = new FileOutputStream(targetFile, true);
                byte[] buffer = new byte[1024];
                int realLength = 0;
                while ((realLength = bufferIn.read(buffer, 0, buffer.length)) != -1) {
                    out.write(buffer, 0, realLength);
                }
            } catch (IOException e) {
                String msg = "服务器拷贝文件失败";
                result.put("code", Constants.ERROR);
                result.put("msg", msg );
                return result;
            } finally {
                try {
                    if (fileIns != null) {
                        fileIns.close();
                    }
                    if (bufferIn != null) {
                        bufferIn.close();
                    }
                    if (out != null) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Image image = new Image();
            String imageId = UUID.randomUUID().toString();
            image.setImgId(imageId);
            image.setImgName(fileFileName);
            image.setFileSize(fileSize);
            image.setCreateTime(new Date());
            image.setDownloadUrl(filename);
            image.setFullSavePath(targetFilePath);
            int nount = imageService.insert(image);
            if(nount > 0) {
                result.put("code", Constants.SUCCESS);
                result.put("data", image);
            }
        }catch (Exception e) {
            result.put("code", Constants.SYS_ERROR);
            result.put("msg", "系统错误请联系管理人员");
            e.printStackTrace();
        }
        return result;
    }


}
