package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
* @Description:    文件上传控制器
* @Author:         TJX
* @CreateDate:     2019-04-30 17:54
* @UpdateUser:
* @UpdateDate:     2019-04-30 17:54
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/upload")
public class UploadConroller {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/photo/employer")
    public Result uploadOfEmployer(@RequestParam("photo") MultipartFile multipartFile)
    {
        /**
        * @Description: 上传员工照片
        * @Author:      TJX
         * @param multipartFile
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-30 17:57
        */
        return uploadService.uploadOfEmployer(multipartFile);
    }

    @PostMapping(value = "/photo/oldPeople")
    public Result uploadOfOldpeople(@RequestParam("photo") MultipartFile multipartFile)
    {
        /**
        * @Description: 上传老人照片
        * @Author:      TJX
         * @param multipartFile
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-04-30 17:59
        */
        return uploadService.uploadOfOldpeople(multipartFile);
    }
}
