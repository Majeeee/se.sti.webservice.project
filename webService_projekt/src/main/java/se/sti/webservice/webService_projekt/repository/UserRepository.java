package se.sti.webservice.webService_projekt.repository;

import  se.sti.webservice.webService_projekt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }