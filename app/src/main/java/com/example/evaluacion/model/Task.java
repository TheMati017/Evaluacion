package com.example.evaluacion.model;

/**
 * Modelo de datos que representa una tarea de la aplicación TaskMaster.
 * Es un módulo independiente y reutilizable por cualquier pantalla que
 * necesite crear, leer o mostrar tareas.
 */
public class Task {

    private String title;
    private String description;
    private String category;
    private String priority;
    private int importance;
    private boolean completed;

    public Task(String title, String description, String category,
                String priority, int importance, boolean completed) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.importance = importance;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public int getImportance() {
        return importance;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
