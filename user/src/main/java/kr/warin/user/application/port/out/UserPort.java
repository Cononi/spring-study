package kr.warin.user.application.port.out;

import kr.warin.user.adapter.out.ApplicationUser;
import kr.warin.user.domain.UserInfo;

public interface UserPort {

    ApplicationUser findByUsername(String username);

    ApplicationUser registerUser(UserInfo userInfo);
}
