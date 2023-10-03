package kr.warin.user.adapter.out;

import kr.warin.user.application.port.out.UserPort;
import kr.warin.user.common.annotation.PersistenceAdapter;
import kr.warin.user.common.base.ResultCode;
import kr.warin.user.common.exceptions.EntityDataNotFoundException;
import kr.warin.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class UserAdapter implements UserPort {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public ApplicationUser findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityDataNotFoundException(ResultCode.FAIL));
        return userMapper.mapToApplicationUser(user);
    }

    @Override
    public ApplicationUser registerUser(UserInfo userInfo) {
        if(userRepository.findByUsername(userInfo.username()).isPresent())
            throw new EntityDataNotFoundException(ResultCode.FAIL);
        User user = userRepository.save(userMapper.mapToUser(userInfo));
        return userMapper.mapToApplicationUser(user);
    }


}
