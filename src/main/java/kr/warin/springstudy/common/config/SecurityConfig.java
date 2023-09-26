package kr.warin.springstudy.common.config;

import kr.warin.springstudy.common.filter.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {
    // BCryptPasswordEncoder 인스턴스 생성
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/students").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/student/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/student").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/student/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/student/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/api/user/create").permitAll()
                        .anyRequest().permitAll()
        );

        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable); // 외부 요청 허용
        return http.build();
    }


}
