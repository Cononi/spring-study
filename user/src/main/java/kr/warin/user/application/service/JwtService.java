package kr.warin.user.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import kr.warin.user.application.port.in.JwtUseCase;
import kr.warin.user.common.base.ResultCode;
import kr.warin.user.common.exceptions.EntityDataNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JwtService implements JwtUseCase {

    @Value("${secret.jwt.key}")
    private String secretKey; // 시크릿키
    @Value("${secret.jwt.issuer}")
    private String issuer; // 발행자

    @Override
    public String createAccessToken(String username) {
        return JWT.create()
                .withIssuer(issuer)
                .withSubject("hong") // 작성자
                .withExpiresAt(createDate(LocalDateTime.now().plusMinutes(30))) // 만료일
                .withIssuedAt(createDate(LocalDateTime.now()))   // 생성일
                .sign(Algorithm.HMAC512(secretKey));
    }

    @Override
    public String createRefreshToken(String username) {
        return JWT.create()
                .withExpiresAt(createDate(LocalDateTime.now().plusMonths(1))) // 만료일
                .withIssuedAt(createDate(LocalDateTime.now()))   // 생성일
                .sign(Algorithm.HMAC512(secretKey));
    }

    @Override
    public DecodedJWT verifyToken(String token) {

        return jwtVerifier(token,secretKey);
    }

}
