package se.sti.webservice.webService_projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String id) {
        Todo todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}