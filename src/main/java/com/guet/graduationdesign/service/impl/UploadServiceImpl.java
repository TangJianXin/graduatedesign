package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.service.UploadService;
import com.guet.graduationdesign.util.MultipartFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
* @Description:    文件上传service
* @Author:         TJX
* @CreateDate:     2019-04-30 17:53
* @UpdateUser:
* @UpdateDate:     2019-04-30 17:53
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String uploadOfEmployer(MultipartFile multipartFile) {
        /**
        * @Description: 员工文件上传
        * @Author:      TJX
         * @param multipartFile
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-30 17:54
        */
        return MultipartFileUtil.saveFile(multipartFile,"employer");
    }

    @Override
    public String uploadOfOldpeople(MultipartFile multipartFile) {
        /**
        * @Description: 老人文件上传
        * @Author:      TJX
         * @param multipartFile
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-04-30 17:54
        */
        return MultipartFileUtil.saveFile(multipartFile,"oldPeople");
    }
}
