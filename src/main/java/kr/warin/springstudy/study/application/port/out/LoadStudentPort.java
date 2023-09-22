package kr.warin.springstudy.study.application.port.out;

import kr.warin.springstudy.study.domain.Student;

import java.util.List;

public interface LoadStudentPort {

    Student loadStudent(Long id);

    boolean isStudent(Long id);
    List<Student> loadStudents();


}
