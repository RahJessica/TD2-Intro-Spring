package org.example.td2introspring.service;

import org.example.td2introspring.dto.StudentRequest;
import org.example.td2introspring.entity.Student;
import org.example.td2introspring.validator.StudentValidator;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final StudentValidator validator;
    private final List<Student> students = new ArrayList<>();

    public StudentService(StudentValidator validator) {
        this.validator = validator;
    }

    public List<Student> createStudents(List<StudentRequest> requests) {

        for (StudentRequest req : requests) {

            validator.validate(req);

            Student s = new Student();
            s.setReference(req.getReference());

            students.add(s);
        }

        return students;
    }
}
