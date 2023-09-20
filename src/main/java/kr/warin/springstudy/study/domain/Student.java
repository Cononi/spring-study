package kr.warin.springstudy.study.domain;


import kr.warin.springstudy.study.adapter.out.StudentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Student {
    private Long id;
    private String name;
    private String email;

    public static StudentEntity from(Student entity) {
        return StudentEntity.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    public static Student from(StudentEntity entity) {
        return Student.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }
}
