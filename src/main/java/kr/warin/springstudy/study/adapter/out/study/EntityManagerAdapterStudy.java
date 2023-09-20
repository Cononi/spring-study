package kr.warin.springstudy.study.adapter.out.study;

import kr.warin.springstudy.annotation.PersistenceAdapter;
import kr.warin.springstudy.study.application.port.out.study.SaveStudentPortStudy;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class EntityManagerAdapterStudy implements SaveStudentPortStudy {

    private final EntityManagerStudy entityManagerStudy;
    private final EntityManagerMapperStudy entityManagerMapperStudy;

    @Override
    public void saveStudent(Student student) {
        entityManagerStudy.save(
                entityManagerMapperStudy.mapToEntity(student)
        );
    }
}
