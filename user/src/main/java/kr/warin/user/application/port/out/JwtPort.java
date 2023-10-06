package kr.warin.user.application.port.out;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public interface JwtPort {

    String createAccessToken(UserDetails userDetails);
    String createRefreshToken(UserDetails userDetails);
    boolean verifyToken(String token,UserDetails userDetails);

    default String getUsername(String token,String secretKey){
        return JWT.decode(token).getSubject();
    }
    default Claim getClaim(String token, String claimName){
        return JWT.decode(token).getClaim(claimName);
    }

    default Map<String, Claim> getAllClaims(String token){
        return JWT.decode(token).getClaims();
    }

    /**
     * 토큰 서명의 유효성을 검사하는 데 사용할 알고리즘이 포함된 검증기 생성
     * 그리고 토큰이 유효하고 만료되지 않았다면 사용자 이름을 반환
     * @param token 토큰값
     * @param secretKey 시크릿키
     * @return JWT의 서명 및 클레임 확인 및 검증
     */
    default String jwtVerifier(String token,String secretKey, String issuer){
        Algorithm algorithm = Algorithm.HMAC512(secretKey);
        DecodedJWT verified = JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(token);
        return verified.getSubject();
    }

    default Date createDate(LocalDateTime time){
        return java.sql.Timestamp.valueOf(time);
    }

}
