package kr.warin.user.application.service;

import kr.warin.user.application.port.in.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1L,"USER"));
//        return new ApplicationUser(UserEntity.builder()
//                .id(1L)
//                .username("hong")
//                .password(encoder.encode("123"))
//                .role()
//                .build()
//        );
        return null;
    }
}
