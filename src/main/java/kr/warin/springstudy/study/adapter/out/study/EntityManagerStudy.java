package kr.warin.springstudy.study.adapter.out.study;

import jakarta.persistence.EntityManager;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EntityManagerStudy {
    private final EntityManager entityManager;

    public EntityManagerStudy(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(StudentEntity student){
        entityManager.persist(student);
    }
}
