package kr.warin.springstudy.study.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Hello World";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Hello World";
    }


}
