package kr.warin.springstudy.study.application.port.out;

import kr.warin.springstudy.study.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoadStudentPort {

    Student loadStudent(Long id);

    Page<Student> loadStudentPage();

    boolean isStudent(Long id);
    List<Student> loadStudents();

}
