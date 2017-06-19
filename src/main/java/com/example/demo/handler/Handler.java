package com.example.demo.handler;

import com.example.demo.domain.Result;
import com.example.demo.domain.User;
import com.example.demo.exception.UserException;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if(e instanceof UserException) {
            UserException ue = (UserException)e;
            return ResultUtil.fail(ue.getCode(), ue.getMessage());
        }
        return ResultUtil.fail(-1, e.getMessage());
    }

}
