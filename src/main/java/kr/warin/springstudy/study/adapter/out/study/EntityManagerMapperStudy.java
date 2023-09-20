package kr.warin.springstudy.study.adapter.out.study;

import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.domain.Student;
import org.springframework.stereotype.Component;

@Component
// 나는 변환만을 담당.!
public class EntityManagerMapperStudy {


     Student mapToDomainEntity(StudentEntity student) {
        return Student.from(student);
    }

    StudentEntity mapToEntity(Student student){
        return Student.from(student);
    }
}
