package com.bjpowernode.crm.commons.domain;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/5 11:41 crm-project
 */


public class ReturnObject {
    private String code;        //处理成功或失败的标记 1--成功 0--失败
    private String message;     //返回提示信息
    private Object returnData;     //返回其他属性

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }
}
