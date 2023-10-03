package kr.warin.user.application.port.in;

import kr.warin.user.adapter.out.ApplicationUser;
import kr.warin.user.domain.Token;
import kr.warin.user.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserUseCase extends UserDetailsService {
}
