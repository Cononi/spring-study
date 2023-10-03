package kr.warin.user.application.service;

import kr.warin.user.application.port.in.UserUseCase;
import kr.warin.user.application.port.out.UserPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserUseCase {
    private final UserPort userPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("테스트 ||| {}", "");
        return userPort.findByUsername(username);
    }

}
