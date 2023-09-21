package kr.warin.springstudy.study.adapter.in;

import kr.warin.springstudy.study.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentController {

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        List<Student> theStudentList = new ArrayList<>();
        theStudentList.add(new Student(1L,"name","is"));
        theStudentList.add(new Student(2L,"is","what"));
        theStudentList.add(new Student(3L,"what","name"));

        return theStudentList.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudentList = new ArrayList<>();
        theStudentList.add(new Student(1L,"name","is"));
        theStudentList.add(new Student(2L,"is","what"));
        theStudentList.add(new Student(3L,"what","name"));

        return theStudentList;
    }
}
