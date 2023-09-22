package kr.warin.springstudy.study.adapter.out;

import kr.warin.springstudy.study.domain.Student;
import org.springframework.stereotype.Component;

@Component
// 도메인 계층에서 특정 행동으로 변환이 필요하면 여기를 사용해서 변환 로직을 실행한다.
public class StudentMapper {
    public Student mapToDomainEntity(StudentEntity student){
        return Student.from(student);
    }

    public StudentEntity mapToEntity(Student student){
        return Student.from(student);
    }

}
