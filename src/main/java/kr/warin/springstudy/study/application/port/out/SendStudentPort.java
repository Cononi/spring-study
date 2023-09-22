package kr.warin.springstudy.study.application.port.out;

import kr.warin.springstudy.study.domain.Student;

public interface SendStudentPort {

    void sendStudent(Student student);

    void deleteStudent(Student student);
}
