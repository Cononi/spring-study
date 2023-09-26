package kr.warin.springstudy.study.application.port.in;

import kr.warin.springstudy.study.domain.UserInfo;

public interface UserUseCase {

    void createUser(UserInfo user);
}
