package kr.warin.user.adapter.in;

import kr.warin.user.common.base.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/test")
    public ResponseData<String> test(){
        return ResponseData.ok("TEST");
    }

}
