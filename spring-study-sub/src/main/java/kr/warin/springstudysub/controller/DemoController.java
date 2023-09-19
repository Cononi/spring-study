package kr.warin.springstudysub.controller;

import kr.warin.springstudysub.domain.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;
//    private final Coach anotherCoach;

//    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
//                          @Qualifier("cricketCoach") Coach anotherCoach) {
//        System.out.println("현재 생성자 : " + getClass().getSimpleName());
//        this.myCoach = myCoach;
//        this.anotherCoach = anotherCoach;
//    }

    public DemoController(@Qualifier("aquatio") Coach theCoach) {
        System.out.println("현재 생성자 : " + getClass().getSimpleName());
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check(){
//        return "이 빈들은 같은 빈인가? myCoach == anotherCoach, "
//                + (myCoach == anotherCoach);
//    }
}
