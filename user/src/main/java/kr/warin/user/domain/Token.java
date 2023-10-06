package kr.warin.user.domain;

import lombok.Builder;

@Builder
public record Token(
        String accessToken,
        String refreshToken
){
}
