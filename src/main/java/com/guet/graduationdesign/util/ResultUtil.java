package com.guet.graduationdesign.util;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.result.Result;

/**
* @Description:    统一返回结果的工具类
* @Author:         TJX
* @CreateDate:     2019-05-02 18:19
* @UpdateUser:
* @UpdateDate:     2019-05-02 18:19
* @UpdateRemark:
* @Version:        1.0
*/
public class ResultUtil {

    public static Result getResult(ResultEnum resultEnum)
    {
        /**
        * @Description: 构造返回结果对象
        * @Author:      TJX
         * @param resultEnum
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 18:19
        */
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessgae(resultEnum.getMessage());
        return result;
    }

    public static Result success(ResultEnum resultEnum)
    {
        /**
        * @Description: 不包含返回数据的成功操作
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 18:44
        */
        return getResult(resultEnum);
    }

    public static Result success(ResultEnum resultEnum,Object data)
    {
        /**
        * @Description: 包含返回数据的成功操作
        * @Author:      TJX
         * @param resultEnum
         * @param data
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 18:46
        */
        Result result = getResult(resultEnum);
        result.setData(data);
        return result;
    }

    public static Result fail(ResultEnum resultEnum)
    {
        /**
        * @Description: 操作失败返回结果
        * @Author:      TJX
         * @param
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 18:51
        */
        return getResult(resultEnum);
    }

    public static Result fail(Integer code,String message)
    {
        /**
        * @Description:
        * @Author:      TJX
         * @param code
         * @param message
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 19:27
        */
        Result result = new Result();
        result.setCode(code);
        result.setMessgae(message);
        return result;
    }
}
