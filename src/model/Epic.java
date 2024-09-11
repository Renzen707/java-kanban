package model;

import java.util.ArrayList;

public class Epic extends Task{

    private ArrayList<Integer> subTasks = new ArrayList<>();

    public Epic(String taskName, String description) {
        super(taskName, description);
    }

}
