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
    public ResponseEntity<?> createStudents(@RequestBody List<Student> students) {
        try {
            studentsList.addAll(students);
            return ResponseEntity.status(201).body(studentsList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur serveur");
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {

        if (acceptHeader == null) {
            return ResponseEntity.status(400).body("Header Accept manquant");
        }

        if (!acceptHeader.equals("text/plain") && !acceptHeader.equals("application/json")) {
            return ResponseEntity.status(501).body("Format non supporté");
        }

        try {
            if (acceptHeader.equals("application/json")) {
                return ResponseEntity.ok(studentsList);
            } else {
                String names = studentsList.stream()
                        .map(Student::getFirstName)
                        .collect(Collectors.joining(", "));
                return ResponseEntity.ok(names);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur serveur");
        }
    }
}
