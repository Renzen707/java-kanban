package service;

import model.*;

import java.util.HashMap;


public class TaskService {
    public int taskCount;

    protected final HashMap<Integer, Task> taskMap = new HashMap<>();
    protected final HashMap<Integer, Epic> epicMap = new HashMap<>();
    protected final HashMap<Integer, SubTask> subtaskMap = new HashMap<>();


    public TaskService() {
        this.taskCount = 0;
    }

    public Task create(Task task) {
        return task;
    }

    public Task get(int id) {

        return null;
    }

    public void update(Task taskFromManager) {

    }

    public void delete(int id) {

    }
}