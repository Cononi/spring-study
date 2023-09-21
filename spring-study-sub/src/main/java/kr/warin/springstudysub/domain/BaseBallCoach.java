package kr.warin.springstudysub.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseBallCoach implements Coach{

    public BaseBallCoach() {
        System.out.println("현재 생성자 : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "베이스볼 코치 입니다.";
    }
}
