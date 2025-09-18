package se.sti.webservice.webService_projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.sti.webservice.webService_projekt.model.User;
import se.sti.webservice.webService_projekt.model.Todo;
import se.sti.webservice.webService_projekt.repository.UserRepository;
import se.sti.webservice.webService_projekt.exception.UserNotFoundException;
import se.sti.webservice.webService_projekt.exception.ToDoNotFoundException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Todo updateToDo(String userId, String todoId, Todo updatedToDo) {
        // Hämta användare
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        List<Todo> todos = user.getTodos();
        boolean found = false;

        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            if (todo.getId().equals(todoId)) {
                updatedToDo.setId(todoId); // säkerställ rätt ID
                todos.set(i, updatedToDo);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new ToDoNotFoundException(todoId);
        }

        user.setTodos(todos);
        userRepository.save(user);

        return updatedToDo;
    }
    public Todo addTodoToUser(String userId, Todo newTodo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        // Om listan är null, skapa en ny
        if (user.getTodos() == null) {
            user.setTodos(new java.util.ArrayList<>());
        }

        user.getTodos().add(newTodo);
        userRepository.save(user);

        return newTodo;
    }

}
