// exception/UserNotFoundException.java
package se.sti.webservice.webService_projekt.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User not found with id: " + id);
    }
}
