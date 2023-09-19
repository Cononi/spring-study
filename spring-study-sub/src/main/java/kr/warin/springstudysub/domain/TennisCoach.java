package kr.warin.springstudysub.domain;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("현재 생성자 : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "테니스 코치 입니다.";
    }
}
