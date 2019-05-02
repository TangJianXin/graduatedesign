package com.guet.graduationdesign.handle;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.result.Result;
import com.guet.graduationdesign.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Description:    统一异常处理类
* @Author:         TJX
* @CreateDate:     2019-05-02 19:28
* @UpdateUser:
* @UpdateDate:     2019-05-02 19:28
* @UpdateRemark:
* @Version:        1.0
*/
@ControllerAdvice
public class HandleException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        /**
        * @Description: 统一异常处理
        * @Author:      TJX
         * @param e
        * @Return      com.guet.graduationdesign.result.Result
        * @Exception
        * @Date        2019-05-02 19:28
        */
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUtil.fail(myException.getCode(),myException.getMessage());
        } else {
            e.printStackTrace();
            return ResultUtil.fail(ResultEnum.UNKONW_EXCEPTION);
        }
    }
}