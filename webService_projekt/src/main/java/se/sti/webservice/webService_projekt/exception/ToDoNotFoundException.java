// exception/ToDoNotFoundException.java
package se.sti.webservice.webService_projekt.exception;

public class ToDoNotFoundException extends RuntimeException {
  public ToDoNotFoundException(String id) {
    super("ToDo not found with id: " + id);
  }
}
