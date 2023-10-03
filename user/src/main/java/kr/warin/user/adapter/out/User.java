package kr.warin.user.adapter.out;


import jakarta.persistence.*;
import kr.warin.user.common.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
