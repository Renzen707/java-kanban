import service.TaskService;
import model.*;

import static model.Status.NEW;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskService taskService = new TaskService();
        Task task = taskService.create(new Task("Новая задача", NEW, "Описание задачи"));
        System.out.println("Create task: " + task);

        Task taskFromService = taskService.getTask(task.getId());
        System.out.println("Get task: " + taskFromService);

        taskFromService.setName("New name");
        taskService.updateTask(taskFromService);
        System.out.println("Update task: " + taskFromService);

        taskService.deleteTask(taskFromService.getId());
        System.out.println("Delete: " + task);

    }
}
