package se.sti.webservice.webService_projekt.controller;

import se.sti.webservice.webService_projekt.model.User;
import se.sti.webservice.webService_projekt.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // Endast för test: populate sample users into user_example collection
    @PostMapping("/populate")
    public ResponseEntity<List<User>> populate() {
        User a = new User("Anna Andersson", "anna@example.com");
        User b = new User("Bertil Berg", "bertil@example.com");
        repo.saveAll(Arrays.asList(a,b));
        return ResponseEntity.status(201).body(repo.findAll());
    }
}