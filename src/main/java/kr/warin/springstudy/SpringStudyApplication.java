package kr.warin.springstudy;

import kr.warin.springstudy.study.adapter.out.study.EntityManagerStudy;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
import kr.warin.springstudy.study.application.port.out.study.SaveStudentPortStudy;
import kr.warin.springstudy.study.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

	/**
	@Bean
	public CommandLineRunner commandLineRunner(SaveStudentPortStudy entityManagerStudy){

		return runner -> {
			createStudent(entityManagerStudy);
		};
	}

	private void createStudent(SaveStudentPortStudy entityManagerStudy) {
		// Create
		Student student = Student.builder()
				.name("jj")
				.email("h@h.com")
				.build();
		entityManagerStudy.saveStudent(student);

		// Read
		Student response = entityManagerStudy.findById(1L);
		System.out.println("Student Data :" + response.id());

		// Update
		StudentEntity studentEntity = StudentEntity.builder()
				.id(response.id())
				.email("gg@gg.com")
				.name(response.name())
				.build();
		entityManagerStudy.updatedStudent(studentEntity);

		// 전체 조회
		List<Student> domains = entityManagerStudy.findAll();
		for(Student s : domains) {
			System.out.println("Student" + s);
		}

		// Delete
		System.out.println("Student DELETE" + response);
		entityManagerStudy.removeStudent(response);
    }
	*/

}
