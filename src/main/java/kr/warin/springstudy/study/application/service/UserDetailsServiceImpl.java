package kr.warin.springstudy.study.application.service;

import kr.warin.springstudy.study.adapter.out.common.UserEntity;
import kr.warin.springstudy.study.adapter.out.common.UserRepository;
import kr.warin.springstudy.study.application.port.in.UserUseCase;
import kr.warin.springstudy.study.application.port.out.UserPort;
import kr.warin.springstudy.study.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userPort.findByUsername(username);
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

}
