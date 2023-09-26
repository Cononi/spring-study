package kr.warin.springstudy.study.application.port.out;

import kr.warin.springstudy.study.adapter.out.common.UserEntity;
import kr.warin.springstudy.study.domain.UserInfo;

public interface UserPort {

    void creat(UserInfo user);

    void delete();

    UserEntity get(String username);

}
