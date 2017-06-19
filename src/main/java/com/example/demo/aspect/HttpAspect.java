package com.example.demo.aspect;

import com.example.demo.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by haishand on 2017/6/19.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.UserController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // class method
        logger.info("class_method={}", point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());

        // args
        logger.info("args={}", point.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("4444");
    }

    @AfterReturning(returning = "user", pointcut = "log()")
    public void doAfterReturning(User user) {
        logger.info("response={}", user);
    }
}
