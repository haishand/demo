package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * Created by haishand on 2017/6/19.
 */
public class ResultUtil {
    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result fail(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        result.setData(null);
        return result;
    }
}
