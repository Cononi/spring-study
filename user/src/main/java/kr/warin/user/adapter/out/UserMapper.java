package kr.warin.user.adapter.out;

import kr.warin.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ApplicationUser mapToApplicationUser(User user) {
        return new ApplicationUser(user);
    }

    public User mapToUser(UserInfo userInfo) {
        return User.builder()
                .username(userInfo.username())
                .password(userInfo.password())
                .role(Role.USER)
                .build();
    }

}
