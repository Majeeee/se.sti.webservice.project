package se.sti.webservice.webService_projekt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
public class Todo {
    @Id
    private String id;
    private String title;
    private boolean completed;

    // getters and setters
}