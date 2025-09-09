package se.sti.webservice.webService_projekt.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import se.sti.webservice.webService_projekt.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> { }
