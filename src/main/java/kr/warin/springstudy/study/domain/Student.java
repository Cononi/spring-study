package kr.warin.springstudy.study.domain;


import kr.warin.springstudy.study.adapter.out.StudentEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student {
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
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }
}
