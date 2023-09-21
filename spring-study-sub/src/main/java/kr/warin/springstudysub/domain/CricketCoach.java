package kr.warin.springstudysub.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// 빈의 생성 및 초기화에 다른 인스턴스 생성 범위 지정
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("현재 생성자 : " + getClass().getSimpleName());
    }
//    // 메소드 초기화 정의
//    @PostConstruct
//    public void init(){
//        System.out.println("In init(): " + getClass().getSimpleName());
//
//    }
//    // 메소드 파괴 정의
//    @PreDestroy
//    public void destroy(){
//        System.out.println("In destroy(): " + getClass().getSimpleName());
//    }


    @Override
    public String getDailyWorkout() {
        return "오늘의 일은 오늘 하자.";
    }
}
