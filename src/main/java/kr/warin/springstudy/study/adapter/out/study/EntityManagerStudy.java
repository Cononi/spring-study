package kr.warin.springstudy.study.adapter.out.study;

import jakarta.persistence.EntityManager;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
// 난 데이터베이스와 상호작용하는 클래스 및 인터페이스
public class EntityManagerStudy {
    private final EntityManager entityManager;

    public EntityManagerStudy(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(StudentEntity student){
        entityManager.persist(student);
    }

    public StudentEntity findById(Long id){
        return entityManager.find(StudentEntity.class, id);
    }

    @Transactional
    public void update(StudentEntity student){
        entityManager.merge(student);
    }

    @Transactional
    public void delete(StudentEntity student){
        entityManager.remove(student);
    }
}
