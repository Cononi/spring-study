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

@EnableJpaAuditing
@SpringBootApplication
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

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
		System.out.println("Student Data :" + response.getEmail());

		// Update
		StudentEntity studentEntity = StudentEntity.builder()
				.id(response.getId())
				.email("gg@gg.com")
				.name(response.getName())
				.build();
		entityManagerStudy.updatedStudent(studentEntity);

		// Delete
		Student response2 = entityManagerStudy.findById(1L);
		System.out.println("Student Delete Data :" + response2.getId());
		entityManagerStudy.removeStudent(response2);
	}


}
