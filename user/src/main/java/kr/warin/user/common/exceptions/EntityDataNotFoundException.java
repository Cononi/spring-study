package kr.warin.user.common.exceptions;

import kr.warin.user.common.base.ResultCode;
import lombok.Getter;

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
