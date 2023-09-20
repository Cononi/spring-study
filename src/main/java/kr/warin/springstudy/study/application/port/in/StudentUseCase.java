package kr.warin.springstudy.study.application.port.in;

import kr.warin.springstudy.study.domain.Student;

public interface StudentUseCase {

    void save(Student student);
}
