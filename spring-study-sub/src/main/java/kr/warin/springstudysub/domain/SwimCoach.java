package kr.warin.springstudysub.domain;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("현재 생성자 : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "수영 전문가";
    }
}
