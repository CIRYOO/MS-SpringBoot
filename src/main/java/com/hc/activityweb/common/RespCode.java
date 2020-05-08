package com.hc.activityweb.common;

public enum RespCode {
    SUCCESS(200,"请求成功"),
    WARN(401,"网络异常，请稍后重试"),
    ERROR(500,"服务器内部错误，无法完成请求");

    private int code;
    private String msg;


    RespCode(int code,String msg){
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
