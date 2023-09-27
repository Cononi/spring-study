package kr.warin.user.application.port.in;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public interface JwtUseCase {

    String createAccessToken(String username);
    String createRefreshToken(String username);
    DecodedJWT verifyToken(String token);

    default String getUsername(String token){
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
     * @param token 토큰값
     * @param secretKey 시크릿키
     * @return JWT의 서명 및 클레임 확인 및 검증
     */
    default DecodedJWT jwtVerifier(String token,String secretKey){
        Algorithm algorithm = Algorithm.HMAC512(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    default Date createDate(LocalDateTime time){
        return java.sql.Timestamp.valueOf(time);
    }

}
