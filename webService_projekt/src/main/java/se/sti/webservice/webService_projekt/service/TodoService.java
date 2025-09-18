package se.sti.webservice.webService_projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.repository.TodoRepository;
import se.sti.webservice.webService_projekt.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo getTodo(String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.isCompleted());

        return todoRepository.save(todo);
    }
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodo(String id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        todoRepository.delete(todo);
    }
}