package org.example.td2introspring.controller;

import org.example.td2introspring.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private List<Student> studentsList = new ArrayList<>();

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        studentsList.add(student);
        return student;
    }

    @GetMapping("/students")
    public ResponseEntity<String> getStudentNames(@RequestHeader(value = "Accept", defaultValue = "text/plain") String acceptHeader) {
        if(!acceptHeader.equals("text/plain")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Format non supporté");
        }

        String names = studentsList.stream()
                .map(Student::getFirstName)
                .collect(Collectors.joining(", "));
        return ResponseEntity.ok(names);
    }
}
