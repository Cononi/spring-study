package kr.warin.springstudy.study.adapter.out;

import kr.warin.springstudy.annotation.PersistenceAdapter;
import kr.warin.springstudy.common.base.ResultCode;
import kr.warin.springstudy.common.exceptions.EntityDataNotFoundException;
import kr.warin.springstudy.study.application.port.out.LoadStudentPort;
import kr.warin.springstudy.study.application.port.out.SendStudentPort;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class StudentAdapter implements LoadStudentPort, SendStudentPort {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Student loadStudent(Long id) {
        // GetById가 deprecated 되서 getReferenceById로 변경되었다.
        // getReferenceById - T 반환 타입으로 엔티티의 클래스로 준다. , ID(식별자)타입으로 지정된다.
        // findById - Optional이 있는 반환이다.
        return studentMapper.mapToDomainEntity(
                studentRepository.findById(id)
                        .orElseThrow(() -> new EntityDataNotFoundException(ResultCode.FAIL))
        );
    }

    @Override
    public Page<Student> loadStudentPage(Pageable pageable) {
        return studentRepository
                .findAll(pageable)
                .map(studentMapper::mapToDomainEntity);
    }

    @Override
    public boolean isStudent(Long id) {
        return studentRepository.findById(id)
                .isEmpty();
    }

    @Override
    public List<Student> loadStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public void sendStudent(Student student) {
        studentRepository.save(studentMapper.mapToEntity(student));
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(studentMapper.mapToEntity(student));
    }
}
