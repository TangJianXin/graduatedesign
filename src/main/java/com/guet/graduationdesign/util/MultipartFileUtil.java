package com.guet.graduationdesign.util;


import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
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
    public static String getFile(String url)
    {
        /**
        * @Description: 获取照片
        * @Author:      TJX
         * @param url
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-05-05 20:24
        */
        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(url);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return "data:image/jpg;base64,"+encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
}
