    package org.example.td2introspring.controller;

    import org.example.td2introspring.entity.Welcoming;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class WelcomingController {
        @GetMapping("/welcome")
        public Welcoming welcome(@RequestParam String name) {
            return new Welcoming(name);
        }
    }
