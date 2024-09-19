package model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task{
    private List<SubTask> subTasks = new ArrayList<>();

    public Epic(String name, Status status, String description) {
        super(name, status, description);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addTask(SubTask subTask){

    }

    public void deleteSubtask (SubTask subTask){

    }

    public void clearSubtasks (Epic epic){

    }
}
