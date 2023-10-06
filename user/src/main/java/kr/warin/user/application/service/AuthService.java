package kr.warin.user.application.service;

import jakarta.transaction.Transactional;
import kr.warin.user.adapter.out.ApplicationUser;
import kr.warin.user.application.port.in.JwtUseCase;
import kr.warin.user.application.port.out.JwtPort;
import kr.warin.user.application.port.out.UserPort;
import kr.warin.user.domain.Token;
import kr.warin.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements JwtUseCase {
    private final JwtPort jwtPort;
    private final UserPort userPort;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Token register(UserInfo userInfo) {
        ApplicationUser applicationUser = userPort.registerUser(
                UserInfo.builder()
                        .username(userInfo.username())
                        .password(passwordEncoder.encode(userInfo.password()))
                        .build()
        );
        return Token.builder()
                .accessToken(jwtPort.createAccessToken(applicationUser))
                .refreshToken(jwtPort.createRefreshToken(applicationUser))
                .build();
    }

    @Override
    public Token authenticate(UserInfo userInfo) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInfo.username(),
                        userInfo.password()
                )
        );
        ApplicationUser applicationUser = userPort.findByUsername(userInfo.username());
        return Token.builder()
                .accessToken(jwtPort.createAccessToken(applicationUser))
                .refreshToken(jwtPort.createRefreshToken(applicationUser))
                .build();
    }
}
