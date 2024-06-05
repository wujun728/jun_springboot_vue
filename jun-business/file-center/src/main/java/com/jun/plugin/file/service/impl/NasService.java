//package com.jun.plugin.file.service.impl;
//
//import cn.hutool.core.util.StrUtil;
//import com.jun.plugin.common.constant.CommonConstant;
//import com.jun.plugin.file.model.FileInfo;
//import com.jun.plugin.oss.model.ObjectInfo;
//import com.jun.plugin.oss.properties.FileServerProperties;
//import com.jun.plugin.oss.template.S3Template;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.OutputStream;
//
///**
// * @author zlt
// * @date 2021/2/13
// * <p>
// * Blog: https://zlt2000.gitee.io
// * Github: https://github.com/zlt2000
// */
//@Service
//@ConditionalOnProperty(prefix = FileServerProperties.PREFIX, name = "type", havingValue = "nas")
//public class NasService extends AbstractIFileService {
////    @Resource
////    private S3Template s3Template;
//
//    @Override
//    protected String fileType() {
//        return "nas";
//    }
//
//    @Override
//    protected ObjectInfo uploadFile(MultipartFile file) {
//        return s3Template.upload(file);
//    }
//
//    @Override
//    protected void deleteFile(String objectPath) {
//        S3Object s3Object = parsePath(objectPath);
//        s3Template.delete(s3Object.bucketName, s3Object.objectName);
//    }
//
//    @Override
//    public void out(String id, OutputStream os) {
//        FileInfo fileInfo = baseMapper.selectById(id);
//        if (fileInfo != null) {
//            S3Object s3Object = parsePath(fileInfo.getPath());
//            s3Template.out(s3Object.bucketName, s3Object.objectName, os);
//        }
//    }
//
//    @Setter
//    @Getter
//    private class S3Object {
//        private String bucketName;
//        private String objectName;
//    }
//
//    private S3Object parsePath(String path) {
//        S3Object s3Object = new S3Object();
//        if (StrUtil.isNotEmpty(path)) {
//            int splitIndex = path.lastIndexOf(CommonConstant.PATH_SPLIT);
//            if (splitIndex != -1) {
//                s3Object.bucketName = path.substring(0, splitIndex);
//                s3Object.objectName = path.substring(splitIndex + 1);
//            }
//        }
//        return s3Object;
//    }
//}
