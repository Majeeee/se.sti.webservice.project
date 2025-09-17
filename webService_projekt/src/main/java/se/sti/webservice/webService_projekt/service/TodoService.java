package se.sti.webservice.webService_projekt.service;

import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> findAll() {
        return repo.findAll();
    }

    public Todo create(Todo todo) {
        return repo.save(todo);
    }

    public Optional<Todo> findById(String id) {
        return repo.findById(id);
    }

    public Optional<Todo> update(String id, Todo update) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(update.getTitle());
            existing.setCompleted(update.isCompleted());
            return repo.save(existing);
        });
    }

    public boolean delete(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
