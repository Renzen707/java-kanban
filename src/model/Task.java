package model;

import java.util.Objects;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected Status status;

    public Task(String name, Status status, String description) {
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Задача №" + id +
                ": " + name + '\'' +
                ". Статус: " + status +
                ", описание: " + description + '\'';
    }
}
