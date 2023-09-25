package kr.warin.springstudy.study.application.port.out;

import kr.warin.springstudy.study.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoadStudentPort {

    Student loadStudent(Long id);

    Page<Student> loadStudentPage(Pageable pageable);

    boolean isStudent(Long id);
    List<Student> loadStudents();

}
