package kr.warin.springstudy.common.base;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("0000", "SUCCESS"),
    SAME("1000", "이미 존재하는 값 입니다."),
    NONE_LIST("2000", "리스트가 존재하지 않습니다."),
    FAIL("9999", "RESPONSE FAIL");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
