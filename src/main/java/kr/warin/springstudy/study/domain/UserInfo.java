package kr.warin.springstudy.study.domain;

import kr.warin.springstudy.study.adapter.out.common.Role;
import kr.warin.springstudy.study.adapter.out.common.UserEntity;
import lombok.Builder;

@Builder
public record UserInfo(
        String username,
        String password,
        Role role
) {
    public static UserEntity from(UserInfo entity) {
        return UserEntity.builder()
                .username(entity.username)
                .username(entity.password)
                .roles(entity.role)
                .build();
    }

    public static UserInfo from(UserEntity entity) {
        return UserInfo.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRoles())
                .build();
    }
}
