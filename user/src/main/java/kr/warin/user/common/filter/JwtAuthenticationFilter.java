package kr.warin.user.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.warin.user.application.port.in.JwtUseCase;
import kr.warin.user.application.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 인증 필터 - Authentication
 * extends OncePerRequestFilter (한 번의 요청에 대해 한번만 실행)
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUseCase jwtUseCase;

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
        final String username;
        final String jwt = switch (authHeader.substring(0,6)){
            case "Bearer" -> authHeader.substring(7);
            default -> "0";
        };
        if(jwt.equals("0")) return;
//        username = jwtUseCase.extractUsername(jwt);
    }
}
