package kr.warin.springstudy.common.base;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("0000", "SUCCESS"),
    SAME("1000", "이미 존재하는 값 입니다."),
    NONE_LIST("2000", "리스트가 존재하지 않습니다."),
    PAGE_OVER_FLOW("2100", "최대 읽을 수 있는 페이지 사이즈를 초과 했습니다.한번에 볼 수 있는 페이지 사이즈는 10,30,50,100 입니다."),
    FAIL("9999", "RESPONSE FAIL");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
