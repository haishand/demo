package com.example.demo.domain;

/**
 * http response outer class
 * Created by haishand on 2017/6/19.
 */
public class Result<T> {
    Integer code;
    String msg;
    T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
