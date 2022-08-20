package org.example.common.exception;

/**
 * 公共类：异常码枚举类
 */
public enum ExceptionCode {
    UNKNOWN_EXP ("990001","未知异常！"),
    TIMEOUT_EXP("9900902","超时异常！"),


    INPUT_NULL_EXP("990011","异常：输入不能为空！"),
    INPUT_ILLEGAL_EXP("990012","异常：输入不合法！"),
    INPUT_LENGTH_EXP("990013","异常：输入长度不合法！"),
    MOBILE_VALID_EXP("990014","异常：手机号校验失败！"),

    SQL_EXEC_EXP("990021","异常：SQL执行异常！"),
    SQL_TIMEOUT_EXP("990022","异常：SQL超时异常！");

    private final String exCode;

    private final String exMessage;

    public String getExCode(){
        return this.exCode;
    }

    public String getExMessage(){
        return this.exMessage;
    }

    ExceptionCode(String exCode,String exMessage){
        this.exCode=exCode;
        this.exMessage=exMessage;
    }
}
