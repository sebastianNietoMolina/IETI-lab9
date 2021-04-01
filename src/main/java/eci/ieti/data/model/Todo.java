package eci.ieti.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {
    @Id
    private Long id;
    private String description;
    private int priority;
    private String dueDate;
    private String responsable;
    private String status;

    public Todo(){}

    public Todo(Long id, String description, int priority, String dueDate, String responsable, String status) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsable = responsable;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getresponsable() {
        return responsable;
    }

    public void setresponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, description='%s', priority='%s', dueDate='%s', responsable='%s', status='%s']",
                id, description, priority, dueDate, responsable, status);
    }
}
