package service;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TaskService {
    public int taskCount;

    private HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics;
    HashMap<Integer, SubTask> subTasks;
    int seq = 0;

    private int generateId(){
        return ++seq;
    }

    public TaskService(){
        this.tasks = new HashMap<>();
    }

    public Task create (Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public Epic create (Epic epic) {
        Epic epic1 = new Epic(epic.getName(), Status.NEW, epic.getDescription());
        epic1.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    public SubTask create (SubTask subTask) {
        subTask.setId(generateId());
        subTasks.put(subTask.getId(), subTask);

        Epic epic = epics.get(subTask.getEpic().getId());
        epic.addTask(subTask);
        calculateStatus(epic);
        return subTask;
    }

    public void updateTask (Task task){
        tasks.put(task.getId(), task);
        Task saved = tasks.get(task.getId());
        saved.setName(task.getName());
        saved.setStatus(task.getStatus());
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
        Epic epic = subTask.getEpic();
        Epic savedEpic = epics.get(epic.getId());
        if (savedEpic == null){
            return;
        }
        savedEpic.calculateEpicStatus();
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

        Epic epic = removeSubTask.getEpic();
        Epic epicSaved = epics.get(epic.getId());

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