package kr.warin.springstudysub.config;

import kr.warin.springstudysub.domain.Coach;
import kr.warin.springstudysub.domain.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatio")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
