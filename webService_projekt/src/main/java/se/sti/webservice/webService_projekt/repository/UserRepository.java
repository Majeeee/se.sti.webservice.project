// repository/UserRepository.java
package se.sti.webservice.webService_projekt.repository;

import se.sti.webservice.webService_projekt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
