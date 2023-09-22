package kr.warin.springstudy.study.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.warin.springstudy.study.application.port.in.StudentUseCase;
import kr.warin.springstudy.study.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentUseCase studentUseCase;

    @Autowired
    private ObjectMapper objectMapper; // Jackson ObjectMapper 주입

    @DisplayName("[GET] ID를 통해 Student 정보를 받아옴")
    @Test
    void getStudent() throws Exception {
        // give - 결과를 받음
        MvcResult result = mockMvc.perform(get("/api/student/1"))
                // 200 번 코드를 받음
                .andReturn();

        // when - 테스트 결과와 응답값 받음
        String responseBody = result.getResponse().getContentAsString();
        Student responseObject = objectMapper.readValue(responseBody, Student.class);
        String content = result.getResponse().getContentAsString(); // 응답 본문 가져오기

        // then - 검증
        switch (result.getResponse().getStatus()) {
            case 200 -> {
                assertNull(responseObject.id());
            }
            case 404 -> {
                // Error code 체크
                assertTrue(content.contains("9999"));
            }
        }

    }

    @DisplayName("[POST] Student 정보를 등록")
    @Test
    void addStudent() throws Exception {
        Student jsonBody = Student.builder()
                .name("test")
                .email("kk@kk.com")
                .build();

        // give - 결과를 받음
        mockMvc.perform(
                post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jsonBody)))
                // 200 번 코드를 받음
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("[GET LIST] Student 모든 정보를 받아옴")
    @Test
    void getStudents() {
    }


    @DisplayName("[PUT] Student 정보를 수정")
    @Test
    void updateStudent() {
    }

    @DisplayName("[DELETE] Student 정보를 삭제")
    @Test
    void deleteStudent() {
    }

}