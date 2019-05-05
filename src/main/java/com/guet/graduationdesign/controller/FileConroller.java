package com.guet.graduationdesign.controller;

import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping(value = "file")
public class FileConroller {

    @Autowired
    private FileService fileService;

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
        return fileService.uploadOfEmployer(multipartFile);
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
        return fileService.uploadOfOldpeople(multipartFile);
    }

    @GetMapping(value = "/getPhoto")
    public Result getPhoto(@RequestParam("url") String url)
    {
        /**
        * @Description: 将图片编码后发送
        * @Author:      TJX
         * @param url
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-05 20:33
        */
        return fileService.getPhoto(url);
    }
}
