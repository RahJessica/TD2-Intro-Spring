    package org.example.td2introspring.controller;

    import org.example.td2introspring.entity.Welcoming;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class WelcomingController {
        // required false -> gestion de l'absence du paramètre par moi-même != required true où le param est exigé et son absence est directement géré par spring
        @GetMapping("/welcome")
        public ResponseEntity<?> welcome(@RequestParam(required = false) String name) {
            if (name == null || name.isEmpty()) {
                return ResponseEntity.status(400).body("Paramètre name manquant");
            }
            return ResponseEntity.ok(new Welcoming(name));
        }
    }
