package kr.warin.springstudy.study.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
public record Student(
        Long id,
        @NotBlank(message = "빈값은 허용하지 않습니다.")
        @Size(min = 3, max = 50)
        String name,
        @NotBlank(message = "빈값은 허용하지 않습니다.")
        @Size(min = 3, max = 50)
        String email) {

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
