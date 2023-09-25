package kr.warin.springstudy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/students").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/student/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/student").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/student/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/student/**").hasRole("ADMIN")
        );
        // HTTP Basic 인증을 학성화하고 기본 설정을 사용
        // 사용자 암호는 Base64로 인코딩되며, Authorization 헤더에 전달된다.
        http.httpBasic(Customizer.withDefaults());
        http.cors(AbstractHttpConfigurer::disable);
        // Cross-Site-Request Forgery - 사용자의 웹 애플리케이션에 원치 않은 요청을 보내는 것을 방지
        http.csrf(AbstractHttpConfigurer::disable); // 외부 요청 허용
        return http.build();
    }

    @Bean
    // 인메모리에 생성되는 계정지정
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john")
                .roles("EMPLOYEE")
                .build();
        UserDetails mery = User.builder()
                .username("mery")
                .password("{noop}mery")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails hoon = User.builder()
                .username("hoon")
                .password("{noop}hoon")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mery,hoon);
    }
}
