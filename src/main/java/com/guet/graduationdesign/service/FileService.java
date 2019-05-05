package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    //上传员工的文件
    public Result uploadOfEmployer(MultipartFile multipartFile);

    //上传老人文件
    public Result uploadOfOldpeople(MultipartFile multipartFile);

    //获取照片
    public Result getPhoto(String url);
}
