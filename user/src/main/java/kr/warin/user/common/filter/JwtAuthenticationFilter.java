package kr.warin.user.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.warin.user.adapter.out.Permission;
import kr.warin.user.application.port.in.UserUseCase;
import kr.warin.user.application.port.out.JwtPort;
import kr.warin.user.common.base.ResultCode;
import kr.warin.user.common.exceptions.EntityDataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 인증 필터 - Authentication
 * extends OncePerRequestFilter (한 번의 요청에 대해 한번만 실행)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtPort jwtPort;
    private final UserUseCase userUseCase;

    @Value("${secret.jwt.key}")
    private String secretKey;
    /**
     * 응답과 요청을 필터체인으로 처리하는 곳.
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if(isAuthHeader(authHeader)) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = authHeader.substring(7);
        // 토큰에서 계정 이름 가져오기
        final String username = getUserName(jwt);
        // 토큰 유효 검사 및 유저 정보 기입
        loadUserByUsernameAndAuth(username, jwt, request);
        filterChain.doFilter(request,response);
    }

    /**
     * 비밀번호 인증 토큰 유형에서 사용자 세부 정보, 자격 증명 및 권한을 매개변수로 전달한 다음 Request 세부 정보로 이 인증 토큰을 확장처리 후
     * Security에서 관리하는 공간에 인증 토큰을 업데이트 한다.
     * @param jwt 토큰 정보
     * @param userDetails 유저 상세 정보
     * @param request 서블릿 요청 정보
     */
    private void isTokenValid(String jwt, UserDetails userDetails, HttpServletRequest request) {
        // 토큰이 유효한지 검사
        if(jwtPort.verifyToken(jwt, userDetails)){
            // 사용자 이름 비밀번호 인증 토큰 유형의 객체 생성 (인증 토큰)
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, // 유저 정보
                    null, // 자격 증명
                    userDetails.getAuthorities() // 유저 권한
            );
            // 자세한 정보 제공
            authToken.setDetails(
                    // 웹 인증에 대한 세부정보 (HTTP 요청에 대한 세부정보)
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            // 보안 컨텍스트 홀더 업데이트 ( 컨텍스트 인증 )
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    /**
     * 유저 정보가 컨텍스트에 존재하지 않을 경우, 유저 정보를 검색후 반환해서 해당 유저와 실제 토큰 유저가 동일한 유저인지 검증 실행
     * @param username 유저이름
     * @param jwt 토큰
     * @param request 서블릿 요청 정보
     */
    private void loadUserByUsernameAndAuth(String username, String jwt, HttpServletRequest request){
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userUseCase.loadUserByUsername(username);
            isTokenValid(jwt,userDetails,request);
        }
    }

    /**
     * 토큰에서 유저 이름 가져오기
     * @param jwt 토큰
     * @return
     */
    private String getUserName(String jwt) {
        return jwtPort.getUsername(jwt,secretKey);
    }

    /**
     * 토근 형식 검사 및 null 체크
     * @param authHeader Auth header 정보
     * @return boolean
     */
    private boolean isAuthHeader(String authHeader) {
        return authHeader == null || !authHeader.startsWith("Bearer ");
    }
}
