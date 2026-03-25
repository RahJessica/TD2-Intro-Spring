package org.example.td2introspring.controller;

import org.example.td2introspring.dto.StudentRequest;
import org.example.td2introspring.entity.Student;
import org.example.td2introspring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> createStudents(@RequestBody List<StudentRequest> requests) {

        return ResponseEntity.ok(studentService.createStudents(requests));
    }
}
