package se.sti.webservice.webService_projekt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService toDoService;

    public TodoController(TodoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ResponseEntity<Todo> createToDo(@RequestBody Todo toDo) {
        Todo created = toDoService.createToDo(toDo);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
