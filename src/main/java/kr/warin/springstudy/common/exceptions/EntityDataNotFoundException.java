package kr.warin.springstudy.common.exceptions;

import kr.warin.springstudy.common.base.ResultCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityDataNotFoundException extends RuntimeException {

    private final ResultCode resultCode;
    private final String description;

    public EntityDataNotFoundException(ResultCode resultCode, String description) {
        super(description);
        this.resultCode = resultCode;
        this.description = description;
    }
    public EntityDataNotFoundException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.description = null;
    }
}
