package org.example.common.exception;

import lombok.Getter;

/**
 * 公共类：业务异常
 */
@Getter
public class BusinessException extends RuntimeException{

    private final String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    public BusinessException(ExceptionCode codeEnum){
        super(codeEnum.getExMessage());
        this.code=codeEnum.getExCode();
    }
}
