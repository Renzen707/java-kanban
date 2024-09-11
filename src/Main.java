import service.TaskService;
import model.*;

import static model.Status.NEW;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskService taskService = new TaskService();
        Task task = taskService.create(new Task("Новая задача", NEW, "Описание задачи"));
        System.out.println("Create task: " + task);

        Task taskFromManager = taskService.get(task.getId());
        System.out.println("Get task: " + taskFromManager);

        taskFromManager.setName("New name");
        taskService.update(taskFromManager);
        System.out.println("Update task: " + taskFromManager);

        taskService.delete(taskFromManager.getId());
        System.out.println("Delete: " + task);

    }
}
