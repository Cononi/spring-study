package kr.warin.springstudy;

import kr.warin.springstudy.study.adapter.out.study.EntityManagerStudy;
import kr.warin.springstudy.study.adapter.out.StudentEntity;
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
	public CommandLineRunner commandLineRunner(EntityManagerStudy EntityManagerStudy){

		return runner -> {
			createStudent(EntityManagerStudy);
		};
	}

	private void createStudent(EntityManagerStudy entityManagerStudy) {
		StudentEntity student = Student.from(Student.builder()
				.name("jj")
				.email("h@h.com")
				.build());
		entityManagerStudy.save(student);
	}


}
