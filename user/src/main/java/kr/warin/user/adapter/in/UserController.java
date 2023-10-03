package kr.warin.user.adapter.in;

import kr.warin.user.application.port.in.JwtUseCase;
import kr.warin.user.application.port.in.UserUseCase;
import kr.warin.user.common.base.ResponseData;
import kr.warin.user.domain.Token;
import kr.warin.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserUseCase userUseCase;
    private final JwtUseCase jwtUseCase;

    @GetMapping("/test")
    public ResponseData<String> test(){
        return ResponseData.ok("TEST");
    }


    @PostMapping("/register")
    public ResponseData<Token> register(
            @RequestBody UserInfo userInfo
    ){
        return ResponseData.ok(jwtUseCase.register(userInfo));
    }

    @PostMapping("/authenticate")
    public ResponseData<Token> authenticate(
            @RequestBody UserInfo userInfo
    ){
        return ResponseData.ok(jwtUseCase.authenticate(userInfo));
    }
}
