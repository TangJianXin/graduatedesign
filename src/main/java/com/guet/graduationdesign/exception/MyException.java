package com.guet.graduationdesign.exception;

import com.guet.graduationdesign.enums.ResultEnum;

/**
* @Description:    自定义异常类
* @Author:         TJX
* @CreateDate:     2019-05-02 19:29
* @UpdateUser:
* @UpdateDate:     2019-05-02 19:29
* @UpdateRemark:
* @Version:        1.0
*/
public class MyException extends RuntimeException{

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
