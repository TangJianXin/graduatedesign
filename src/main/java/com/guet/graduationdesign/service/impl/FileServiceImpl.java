package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.result.FileResult;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.service.FileService;
import com.guet.graduationdesign.util.MultipartFileUtil;
import com.guet.graduationdesign.util.ResultUtil;
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
public class FileServiceImpl implements FileService {
    @Override
    public Result uploadOfEmployer(MultipartFile multipartFile) throws MyException {
        /**
        * @Description: 员工文件上传
        * @Author:      TJX
         * @param multipartFile
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:44
        */
        try{
            FileResult fileResult = new FileResult();
            fileResult.setPhoto(MultipartFileUtil.saveFile(multipartFile,"employer"));
            fileResult.setUrl(MultipartFileUtil.getFile(fileResult.getPhoto()));
            return ResultUtil.success(ResultEnum.UPLOAD_SUCCESS,fileResult);        } catch (Exception e)
        {
            throw new MyException(ResultEnum.UPLOAD_FAIL);
        }
    }

    @Override
    public Result uploadOfOldpeople(MultipartFile multipartFile)throws MyException {
        /**
        * @Description: 老人文件上传
        * @Author:      TJX
         * @param multipartFile
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 21:44
        */
        try{
            FileResult fileResult = new FileResult();
            fileResult.setPhoto(MultipartFileUtil.saveFile(multipartFile,"oldPeople"));
            fileResult.setUrl(MultipartFileUtil.getFile(fileResult.getPhoto()));
            return ResultUtil.success(ResultEnum.UPLOAD_SUCCESS,fileResult);
        } catch (Exception e)
        {
            throw new MyException(ResultEnum.UPLOAD_FAIL);
        }
    }

    @Override
    public Result getPhoto(String url)throws MyException {
        /**
        * @Description: 获取照片
        * @Author:      TJX
         * @param url
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-05 20:21
        */
        try{
            return ResultUtil.success(ResultEnum.GETFILE_SUCCESS,MultipartFileUtil.getFile(url));
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.GETFILE_FAIL);
        }
    }
}
