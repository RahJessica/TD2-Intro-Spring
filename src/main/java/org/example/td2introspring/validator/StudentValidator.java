package org.example.td2introspring.validator;

import org.example.td2introspring.dto.StudentRequest;

public class StudentValidator {
    public void validate(StudentRequest request) {

        if (request.getReference() == null || request.getReference().isBlank()) {
            throw new IllegalArgumentException("Reference obligatoire");
        }
    }
}
