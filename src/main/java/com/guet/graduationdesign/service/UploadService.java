package com.guet.graduationdesign.service;

import com.guet.graduationdesign.result.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    //上传员工的文件
    public Result uploadOfEmployer(MultipartFile multipartFile);

    //上传老人文件
    public Result uploadOfOldpeople(MultipartFile multipartFile);
}
