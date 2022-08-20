package org.example.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.common.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理AOP
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex){
        log.error("通用异常：" + ex);
        return new Result(ex);
    }

    @ExceptionHandler(SystemException.class)
    public Result handleSystemException(SystemException ex){
        log.error("系统异常：" + ex);
        return new Result(ex);
    }

    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException ex){
        log.error("业务异常：" + ex);
        return new Result(ex);
    }
}
