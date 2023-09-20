package kr.warin.springstudy.study.adapter.out.study;

import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerMapperStudy {


     Student mapToDomainEntity(StudentEntity student) {
        return Student.from(student);
    }

    StudentEntity mapToEntity(Student student){
        return Student.from(student);
    }
}
