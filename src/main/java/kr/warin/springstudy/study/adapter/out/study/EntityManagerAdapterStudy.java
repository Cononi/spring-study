package kr.warin.springstudy.study.adapter.out.study;

import kr.warin.springstudy.annotation.PersistenceAdapter;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.application.port.out.study.SaveStudentPortStudy;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
// 난 영속성 관련 CRUD와 결합만 담당.
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

    public void removeStudent(Student student){
        entityManagerStudy.delete(
                entityManagerMapperStudy.mapToEntity(student)
        );
    }
}
