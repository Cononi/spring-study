package kr.warin.springstudy.study.adapter.in;

import jakarta.validation.Valid;
import kr.warin.springstudy.common.base.ResponseData;
import kr.warin.springstudy.common.base.ResultCode;
import kr.warin.springstudy.common.exceptions.EntityDataNotFoundException;
import kr.warin.springstudy.study.application.port.in.StudentUseCase;
import kr.warin.springstudy.study.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentUseCase studentUseCase;
    @GetMapping("/student/{id}")
    public ResponseData<Student> getStudent(@PathVariable Long id) {
        return ResponseData.ok(studentUseCase.loadStudent(id));
    }

    @PostMapping("/student")
    public void addStudent(@Valid @RequestBody Student student) {
        studentUseCase.saveStudent(student);
    }
    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentUseCase.updateStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentUseCase.deleteStudent(id);
    }

    @GetMapping("/students")
    public ResponseData<List<Student>> getStudents() {
        return ResponseData.ok(studentUseCase.loadStudents());
    }
}
