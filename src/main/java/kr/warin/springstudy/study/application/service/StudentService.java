package kr.warin.springstudy.study.application.service;

import kr.warin.springstudy.common.base.ResultCode;
import kr.warin.springstudy.common.exceptions.EntityDataNotFoundException;
import kr.warin.springstudy.common.handler.PageHandler;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.application.port.in.StudentUseCase;
import kr.warin.springstudy.study.application.port.out.LoadStudentPort;
import kr.warin.springstudy.study.application.port.out.SendStudentPort;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements StudentUseCase {

    private final LoadStudentPort loadStudentPort;
    private final SendStudentPort updateStudentPort;

    @Override
    public void updateStudent(Long id,Student student) {
        Student findStudent = loadStudentPort.loadStudent(id);
        updateStudentPort.sendStudent(Student.builder()
                .id(findStudent.id())
                .email(student.email())
                .name(student.name())
                .build());
    }

    @Override
    public void saveStudent(Student student) {
        updateStudentPort.sendStudent(student);
    }

    @Override
    public Student loadStudent(Long id) {
        return loadStudentPort.loadStudent(id);
    }

    @Override
    public Page<Student> loadStudentPage(int page, int size) {
        Pageable pageable = PageHandler.createAndValid(page,size);
        Page<Student> students = loadStudentPort.loadStudentPage(pageable);
        if(students.isEmpty()){
            throw new EntityDataNotFoundException(ResultCode.NONE_LIST);
        }
        return students;
    }

    @Override
    public List<Student> loadStudents() {
        List<Student> students = loadStudentPort.loadStudents();
        if(students.isEmpty()){
            throw new EntityDataNotFoundException(ResultCode.NONE_LIST);
        }
        return loadStudentPort.loadStudents();
    }

    @Override
    public void deleteStudent(Long id) {
        Student findStudent = loadStudentPort.loadStudent(id);
        updateStudentPort.deleteStudent(findStudent);
    }
}
