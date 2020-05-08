package com.hc.activityweb.common;

public class ResponseEntity {
    private int code;   //返回状态码，如：200，400
    private String msg; //返回提示信息
    private Object result;       //返回结果数据

    ResponseEntity(RespCode respCode){
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ResponseEntity(RespCode respCode,Object result){
        this(respCode);
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return result;
    }

    public void setData(Object result) {
        this.result = result;
    }
}
