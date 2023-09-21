package kr.warin.springstudy.common.base;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ResponseData<T> (
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp,
        String code,
        String message,
        T data
) {
    // Compact Constructor ( 컴팩트 생성자 )
    // 클래스 생성자와 달리 레코드 생성자에는 공식적인 매개변수 목록이 없으며, 이를 컴팩트 생성자
    //  validation에 사용하기 위한 것이며 가능한 한 간단하게 유지해야한다
//    public BaseResponse {
//    }

    // 생성자 만드는 방법
    public ResponseData(ResultCode code, T data) {
        this(LocalDateTime.now(), code.getCode(), code.getMessage(), data);
    }

    public static <T> ResponseData<T> message(ResultCode code, T data) {
        return new ResponseData<>(code, data);
    }

    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>(ResultCode.SUCCESS, data);
    }

    public static <T> ResponseData<T> fail(T data) {
        return new ResponseData<>(ResultCode.FAIL, data);
    }
}
