package kr.warin.springstudy.study.adapter.out.common;

import kr.warin.springstudy.common.annotation.PersistenceAdapter;
import kr.warin.springstudy.study.application.port.out.UserPort;
import kr.warin.springstudy.study.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserAdapter implements UserPort {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void creat(UserInfo user) {
        userRepository.save(UserEntity.builder()
                        .username(user.username())
                        .password(passwordEncoder.encode(user.password()))
                        .roles(Role.ROLE_USER)
                .build());
    }

    @Override
    public void delete() {

    }

    @Override
    public UserEntity get(String username) {
        return userRepository.findByUsername(username);
    }
}
