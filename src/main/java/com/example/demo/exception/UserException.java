package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class UserException extends RuntimeException {
    Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
