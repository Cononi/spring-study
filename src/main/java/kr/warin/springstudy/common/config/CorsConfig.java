package kr.warin.springstudy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 쿠키 및 인증 자격 증명을 허용할지 여부를 설정합니다.
        config.setAllowCredentials(true);

        // 허용되는 출처 도메인을 설정합니다.
        config.setAllowedOrigins(List.of("http://localhost:3000"));

        // 허용되는 HTTP 메소드를 설정합니다.
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));

        // 허용되는 HTTP 헤더를 설정합니다.
        config.setAllowedHeaders(List.of("*"));

        // CORS 응답에서 노출할 HTTP 헤더를 지정합니다.
        config.setExposedHeaders(List.of("*"));

        // CORS 응답에 대한 캐싱 시간을 설정합니다.
        config.setMaxAge(3600L);

        // URL 기반으로 CORS 설정을 지정하는 데 사용되는 클래스입니다.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // 엔드포인트에 대한 CORS 설정을 지정
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}