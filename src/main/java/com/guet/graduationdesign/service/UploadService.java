package com.guet.graduationdesign.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    //上传员工的文件
    public String uploadOfEmployer(MultipartFile multipartFile);

    //上传老人文件
    public String uploadOfOldpeople(MultipartFile multipartFile);
}
