package kr.warin.user.adapter.in;

import kr.warin.user.common.base.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public ResponseData<String> sayDemo(){
        return ResponseData.ok("Hello Token");
    }
    @GetMapping("/ok")
    public ResponseData<String> sayDemook(){
        return ResponseData.ok("Hello Token");
    }
}
