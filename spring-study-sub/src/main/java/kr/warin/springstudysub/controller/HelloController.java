package kr.warin.springstudysub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/myinfo")
    public String getMyInfo(){
        return """
                %s는 %s다
                """.formatted(name,age);
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }


}
