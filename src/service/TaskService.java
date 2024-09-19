package service;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TaskService {

    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, SubTask> subTasks;
    int seq = 0;

    private int generateId(){
        return ++seq;
    }

    public TaskService(){
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subTasks = new HashMap<>();
    }

    public Task create (Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public Epic create (Epic epic) {
        Epic epic1 = new Epic(epic.getName(), Status.NEW, epic.getDescription());
        epic1.setId(generateId());
        epics.put(epic1.getId(), epic);

        return epic;
    }

    public SubTask create (SubTask subTask) {
        subTask.setId(generateId());
        subTasks.put(subTask.getId(), subTask);

        Epic epic = epics.get(subTask.getEpicId());
        epic.addTask(subTask);
        calculateStatus(epic);
        return subTask;
    }

    public void updateTask (Task task){
        tasks.put(task.getId(), task);
        Task saved = tasks.get(task.getId());
        if (saved == null){
            return;
        }
        saved.setName(task.getName());
        saved.setStatus(task.getStatus());
        saved.setDescription(task.getDescription());
        saved.setId(task.getId());
    }

    public void updateEpic (Epic epic){
        Epic saved = epics.get(epic.getId());
        if (saved == null){
            return;
        }
        saved.setName(epic.getName());
        saved.setDescription(epic.getDescription());
    }

    public void updateSubTask (SubTask subTask){
        int epicId = subTask.getEpicId();
        Epic savedEpic = epics.get(epicId);
        if (savedEpic == null){
            return;
        }
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public SubTask getSubTask(int id) {
        return subTasks.get(id);
    }

    public List<Task> getAllTask(){
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getAllEpic(){
        return new ArrayList<>(epics.values());
    }

    public List<Task> getAllSubTask(){
        return new ArrayList<>(tasks.values());
    }

    public void deleteTask(int id){
        tasks.remove(id);
    }

    public void deleteEpic(int id){
        epics.remove(id);
    }

    public void deleteSubTask(int id) {
        SubTask removeSubTask = subTasks.remove(id);

        Epic epicSaved = epics.get(removeSubTask.getEpicId());

        epicSaved.getSubTasks().remove(removeSubTask);

        calculateStatus(epicSaved);
    }

    public void removeAllTask (Task task){
        tasks.clear();
    }

    public void removeAllEpic (Epic epic){
        epics.clear();
    }

    public void removeAllSubTask (SubTask subTask){
        subTasks.clear();
    }

    private void calculateStatus(Epic epic){
        Status status = Status.NEW;
        epic.setStatus(status);
    }

}