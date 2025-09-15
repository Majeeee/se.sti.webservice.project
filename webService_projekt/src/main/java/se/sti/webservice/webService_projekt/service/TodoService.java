package se.sti.webservice.webService_projekt.service;

import org.springframework.stereotype.Service;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository toDoRepository;

    public TodoService(TodoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Todo createToDo(Todo toDo) {
        return toDoRepository.save(toDo);
    }
}
