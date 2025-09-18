package se.sti.webservice.webService_projekt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.service.UserService;

@RestController
@RequestMapping("/users/{userId}/todos")
public class TodoController {

    private final UserService userService;

    public TodoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Todo> createToDo(
            @PathVariable String userId,
            @RequestBody Todo toDo) {

        Todo created = userService.addTodoToUser(userId, toDo);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateToDo(
            @PathVariable String userId,
            @PathVariable String todoId,
            @RequestBody Todo updatedToDo) {

        Todo updated = userService.updateToDo(userId, todoId, updatedToDo);
        return ResponseEntity.ok(updated);
    }
}
