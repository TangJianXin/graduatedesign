package com.guet.graduationdesign.handle;

import com.guet.graduationdesign.exception.UserException;
import com.guet.graduationdesign.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException bookException = (UserException) e;
            return null;
        } else {
            e.printStackTrace();
            return null;
        }
    }
}