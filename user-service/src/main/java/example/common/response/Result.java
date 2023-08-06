package example.common.response;

import lombok.Data;
import example.common.exception.BusinessException;
import example.common.exception.SystemException;

/**
 * 公共类：返回类
 */
@Data
public class Result {
    /**
     * 响应数据
     */
    private Object returnData;

    /**
     * 响应码
     */
    private String returnCode;

    /**
     * 响应描述
     */
    private String returnMsg;

    public Result(){}

    public Result(String returnCode,String returnMsg){
        this.returnCode=returnCode;
        this.returnMsg=returnMsg;
    }

    public Result(String returnCode,String returnMsg,Object returnData){
        this.returnCode=returnCode;
        this.returnMsg=returnMsg;
        this.returnData = returnData;
    }
    public Result(ReturnCode codeEnum){
        this.returnCode=codeEnum.getCode();
        this.returnMsg=codeEnum.getMessage();
    }
    public Result(ReturnCode codeEnum,Object returnData){
        this.returnCode=codeEnum.getCode();
        this.returnMsg=codeEnum.getMessage();
        this.returnData=returnData;
    }
    public Result(Exception ex){
        this.returnCode=ReturnCode.FAIL.getCode();
        this.returnMsg= ex.getMessage();
    }
    public Result(SystemException ex){
        this.returnCode=ex.getCode();
        this.returnMsg= ex.getMessage();
    }

    public Result(BusinessException ex){
        this.returnCode=ex.getCode();
        this.returnMsg= ex.getMessage();
    }
}
