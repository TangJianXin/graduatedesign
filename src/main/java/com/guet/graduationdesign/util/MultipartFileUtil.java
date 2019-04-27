package com.guet.graduationdesign.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
* @Description:    多媒体文件工具类
* @Author:         TJX
* @CreateDate:     2019-04-27 10:35
* @UpdateUser:
* @UpdateDate:     2019-04-27 10:35
* @UpdateRemark:
* @Version:        1.0
*/
public class MultipartFileUtil {

    private static final String photoSavePath = "/Users/jreen/Documents/photo/";

    public static String saveFile(MultipartFile multipartFile,String identity){
        /**
        * @Description: 保存多媒体文件
        * @Author:      TJX
         * @param multipartFile
        * @Return      boolean
        * @Exception
        * @Date        2019-04-27 10:37
        */
        File dir = new File(photoSavePath+identity+"/");
        if(!dir.exists())
        {
            dir.mkdir();
        }
        if(!multipartFile.isEmpty())
        {
            String fileName = photoSavePath+identity+"/"+multipartFile.getOriginalFilename();
            File file = new File(fileName);
            if(!file.exists())
            {
                BufferedOutputStream out = null;
                try {
                    out = new BufferedOutputStream(new FileOutputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    out.write(multipartFile.getBytes());
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return fileName;
        }
        else {
            return "保存失败";
        }
    }
    public static boolean isSuccess(String photoPath)
    {
        /**
        * @Description:  判断多媒体文件是否保存成功
        * @Author:      TJX
         * @param photoPath
        * @Return      boolean
        * @Exception
        * @Date        2019-04-27 11:02
        */
        if(photoPath.equals("保存失败"))
        {
            return false;
        }
        return true;
    }
}
