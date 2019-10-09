package com.igeekhome.safety_production_system.util;

public class ResultObject {

    public static final Integer SUCCESS_STATUS = 200;
    public static final Integer FAIL_STATUS = 500;
    public static final Integer UNFOUND_STATUS = 404;
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public ResultObject(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultObject() {
    }


    public static ResultObject ok(){
        return new ResultObject(ResultObject.SUCCESS_STATUS,"成功",null);
    }

    public static ResultObject ok(Object data){
        return new ResultObject(ResultObject.SUCCESS_STATUS,"成功",data);
    }

    public static ResultObject fail(Integer code,String msg){
        return new ResultObject(code,msg,null);
    }

    public static ResultObject build(Integer code,String msg,Object obj){
        return new ResultObject(code,msg,obj);
    }
}
