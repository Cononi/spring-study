package kr.warin.springstudy.study.application.port.out.study;

import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.domain.Student;

import java.util.List;

public interface SaveStudentPortStudy {

    void saveStudent(Student student);

    Student findById(Long id);

    void updatedStudent(StudentEntity student);

    void removeStudent(Student student);

    List<Student> findAll();
}
