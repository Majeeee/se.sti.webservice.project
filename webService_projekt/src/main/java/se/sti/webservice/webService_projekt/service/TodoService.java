package se.sti.webservice.webService_projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.repository.TodoRepository;
import se.sti.webservice.webService_projekt.exception.ResourceNotFoundException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(String.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        todoRepository.delete(todo);
    }
}