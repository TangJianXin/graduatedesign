package com.guet.graduationdesign.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:    字符串时间转换为时间对象
* @Author:         TJX
* @CreateDate:     2019-04-30 17:26
* @UpdateUser:
* @UpdateDate:     2019-04-30 17:26
* @UpdateRemark:
* @Version:        1.0
*/
public class DateUtil {

    public static Date getDate(String stringDate)
    {
        /**
        * @Description: 将xxxx-xx-xx时间字符串转换为date对象
        * @Author:      TJX
         * @param stringDate
        * @Return      java.util.Date
        * @Exception
        * @Date        2019-04-30 17:31
        */
        //创建SimpleDateFormat对象实例并定义好转换格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            // 注意格式需要与上面一致，不然会出现异常
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
