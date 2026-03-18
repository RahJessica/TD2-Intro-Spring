package org.example.td2introspring.entity;

public class Welcoming {
    private String message;

    public Welcoming(String name) {
        this.message = "Welcome " + name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
