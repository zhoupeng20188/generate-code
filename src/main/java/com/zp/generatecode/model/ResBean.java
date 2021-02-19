package com.zp.generatecode.model;

/**
 * @Author zp
 * @create 2021/2/19 15:48
 */
public class ResBean {
    private Integer code;
    private String msg;
    private Object data;

    private ResBean(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResBean ok(String msg, Object data){
        return new ResBean(0, msg, data);
    }

    public static ResBean ok(String msg){
        return new ResBean(0, msg, null);
    }

    public static ResBean error(String msg, Object data){
        return new ResBean(1, msg, data);
    }

    public static ResBean error(String msg){
        return new ResBean(1, msg, null);
    }


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
