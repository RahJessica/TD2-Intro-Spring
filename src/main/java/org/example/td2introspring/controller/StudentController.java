package org.example.td2introspring.controller;

import org.example.td2introspring.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return student;
    }
}
