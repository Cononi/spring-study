package kr.warin.springstudy.common.base;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("0000", "SUCCESS"),
    FAIL("9999", "RESPONSE FAIL");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
