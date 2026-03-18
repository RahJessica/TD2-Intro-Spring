package org.example.td2introspring.controller;

import org.example.td2introspring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }
}
