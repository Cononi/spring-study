package kr.warin.springstudy.study.adapter.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.warin.springstudy.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Entity
@Table(name="student")
public class StudentEntity extends BaseEntity {
    private String name;
    private String email;
}