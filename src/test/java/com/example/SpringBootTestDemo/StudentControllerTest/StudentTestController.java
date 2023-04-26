package com.example.SpringBootTestDemo.StudentControllerTest;

import com.example.SpringBootTestDemo.controller.StudentController;
import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.service.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentTestController {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private StudentServices studentservices;
    private Student student;

    @BeforeEach
    void setup(){
        student = new Student(1,"sagar","kochi","8921414623");
    }

    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(1,"sagar","kochi","8921414623");
        Mockito.when(studentservices.addStudent(student)).thenReturn(student);
        mockmvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" +
                                " \"id\" : 1, \r\n" +
                                " \"name\" : \"sagar\", \r\n" +
                                " \"address\" :\"kochi\", \r\n" +
                                " \"rollNo\" : \"8921414623\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
