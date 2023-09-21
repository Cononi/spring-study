package kr.warin.springstudy.study.domain;


import kr.warin.springstudy.study.adapter.out.StudentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public record Student(Long id, String name, String email) {

    public static StudentEntity from(Student entity) {
        return StudentEntity.builder()
                .id(entity.id())
                .name(entity.name())
                .email(entity.email())
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
