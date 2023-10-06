package kr.warin.user.adapter.out;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import kr.warin.user.application.port.out.JwtPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class JwtAdapter implements JwtPort {

    @Value("${secret.jwt.key}")
    private String secretKey; // 시크릿키
    @Value("${secret.jwt.issuer}")
    private String issuer; // 발행자



    @Override
    public String createAccessToken(UserDetails userDetails) {
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(userDetails.getUsername()) // 작성자
                .withExpiresAt(createDate(LocalDateTime.now().plusMinutes(30))) // 만료일
                .withIssuedAt(createDate(LocalDateTime.now()))   // 생성일
                .sign(Algorithm.HMAC512(secretKey));
    }

    @Override
    public String createRefreshToken(UserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername()) // 작성자
                .withExpiresAt(createDate(LocalDateTime.now().plusMonths(1))) // 만료일
                .withIssuedAt(createDate(LocalDateTime.now()))   // 생성일
                .sign(Algorithm.HMAC512(secretKey));
    }

    @Override
    public boolean verifyToken(String token, UserDetails userDetails) {
        return jwtVerifier(token,secretKey,issuer)
                .equals(userDetails.getUsername());
    }

}
