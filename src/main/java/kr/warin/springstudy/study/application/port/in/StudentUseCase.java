package kr.warin.springstudy.study.application.port.in;

import kr.warin.springstudy.study.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentUseCase {

    void updateStudent(Long id, Student student);
    void saveStudent(Student student);
    Student loadStudent(Long id);
    List<Student> loadStudents();

    Page<Student> loadStudentPage();

    void deleteStudent(Long id);

}
