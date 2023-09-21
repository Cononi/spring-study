package kr.warin.springstudy.study.adapter.out.study;

import kr.warin.springstudy.annotation.PersistenceAdapter;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.application.port.out.study.SaveStudentPortStudy;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
//@PersistenceAdapter
public class EntityManagerAdapterStudy implements SaveStudentPortStudy {

    private final EntityManagerStudy entityManagerStudy;
    private final EntityManagerMapperStudy entityManagerMapperStudy;

    @Override
    public void saveStudent(Student student) {
        entityManagerStudy.save(
                entityManagerMapperStudy.mapToEntity(student)
        );
    }

    @Override
    public Student findById(Long id) {
        return entityManagerMapperStudy.mapToDomainEntity(
                entityManagerStudy.findById(id));
    }

    @Override
    public void updatedStudent(StudentEntity student) {
        entityManagerStudy.update(student);
    }
    @Override
    public void removeStudent(Student student){
        entityManagerStudy.delete(
                entityManagerStudy.findById(student.id())
        );
    }
    @Override
    public List<Student> findAll() {
        return entityManagerStudy.findAll()
                .stream().map(Student::from)
                .collect(Collectors.toList());
    }
}
