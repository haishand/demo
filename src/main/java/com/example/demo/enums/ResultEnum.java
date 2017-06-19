package com.example.demo.enums;

public enum ResultEnum {
    UNKOWN(-1, "未知错误"),
    NIUMOWANG(100, "牛魔王"),
    EMEIPAI(101, "峨嵋派");

    int code;
    String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
