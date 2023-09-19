package kr.warin.springstudysub.domain;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "오늘의 일은 오늘 하자.";
    }
}
