package kr.warin.springstudy.common.exceptions;

import kr.warin.springstudy.common.base.ResponseData;
import kr.warin.springstudy.common.base.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityDataNotFoundException.class)
    protected <T> ResponseData<String> entityDataNotFoundException(EntityDataNotFoundException ex){
        return ResponseData.fail(ex.getMessage());
    }
}
