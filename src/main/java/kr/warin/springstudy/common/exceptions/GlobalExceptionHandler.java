package kr.warin.springstudy.common.exceptions;

import kr.warin.springstudy.common.base.ResponseData;
import kr.warin.springstudy.common.base.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityDataNotFoundException.class)
    protected ResponseEntity<ResponseData<String>> entityDataNotFoundException(EntityDataNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseData.fail(ex.getResultCode(),ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseData<String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String defaultMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseData.fail(defaultMessage));
    }


}
