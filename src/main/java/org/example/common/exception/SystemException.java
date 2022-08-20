package org.example.common.exception;

import lombok.Getter;

/**
 * 公共类：系统异常
 */
@Getter
public class SystemException extends RuntimeException{
    private final String code;

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public SystemException(ExceptionCode codeEnum) {
        super(codeEnum.getExMessage());
        this.code=codeEnum.getExCode();
    }
}
