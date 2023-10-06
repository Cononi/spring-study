package kr.warin.user.common.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletResponse;
import kr.warin.user.common.exceptions.EntityDataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
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

    public static <T> ResponseData<T> fail(ResultCode code,T data) {
        return new ResponseData<>(code, data);
    }
    public static void filterResponse(HttpServletResponse response, ResultCode code) throws IOException {
        String json = Optional.of(new ObjectMapper().registerModule(new JavaTimeModule())
                        .writeValueAsString(new ResponseData<>(code, response.getStatus())))
                .orElseThrow(() -> new EntityDataNotFoundException(ResultCode.FAIL));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        log.info("Test : {}", json);
        response.getWriter().write(json);
    }
}
