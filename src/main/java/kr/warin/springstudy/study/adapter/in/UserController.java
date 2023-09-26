package kr.warin.springstudy.study.adapter.in;

import kr.warin.springstudy.study.application.port.in.UserUseCase;
import kr.warin.springstudy.study.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("/user/create")
    public void create(@RequestBody UserInfo user) {
        userUseCase.createUser(user);
    }
}
