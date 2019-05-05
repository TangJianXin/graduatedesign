package com.guet.graduationdesign.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
/**
* @Description:    http请求公共处理
* @Author:         TJX
* @CreateDate:     2019-04-04 20:23
* @UpdateUser:
* @UpdateDate:     2019-04-04 20:23
* @UpdateRemark:
* @Version:        1.0
*/
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.guet.graduationdesign.controller..*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        /**
        * @Description: 请求前的动作,记录请求的url，ip，method，class_method，args
        * @Author:      TJX
         * @param joinPoint
        * @Return      void
        * @Exception
        * @Date        2019-04-04 20:22
        */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("method={}", request.getMethod());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
         //logger.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        /**
        * @Description:  记录请求返回
        * @Author:      TJX
         * @param object
        * @Return      void
        * @Exception
        * @Date        2019-04-04 20:23
        */
        //logger.info("response={}", object.toString());
    }

    @After("log()")
    public void doAfter() {
        /**
        * @Description: 请求后的动作
        * @Author:      TJX
         * @param
        * @Return      void
        * @Exception
        * @Date        2019-04-04 20:23
        */
        logger.info("请求完成");
    }
}