package kr.warin.user.application.port.in;

import kr.warin.user.domain.Token;
import kr.warin.user.domain.UserInfo;

public interface JwtUseCase {
    Token register(UserInfo userInfo);

    Token authenticate(UserInfo userInfo);
}
