package kr.warin.springstudy.study.adapter.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.warin.springstudy.common.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name="student")
public class StudentEntity extends BaseEntity {
    private String name;
    private int age;
    private String email;
}
