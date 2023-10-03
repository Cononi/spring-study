package kr.warin.springstudy.study.application.service;

import kr.warin.springstudy.study.application.port.in.UserUseCase;
import kr.warin.springstudy.study.application.port.out.UserPort;
import kr.warin.springstudy.study.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
//    private final UserPort userPort;

    @Override
    public void createUser(UserInfo user) {
//        userPort.creat(user);
    }
}
