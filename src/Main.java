import service.TaskService;
import model.*;

import static model.Status.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskService taskService = new TaskService();

        Task task1 = taskService.create(new Task("Задача", NEW,"1"));
        Task task2 = taskService.create(new Task("Задача", NEW,"2"));
        Task taskN1 = taskService.getTask(task1.getId());

        taskN1.setStatus(Status.DONE);
        taskService.updateTask(taskN1);

        Epic epic1 = taskService.create(new Epic("epic", NEW,"1"));
        SubTask subTask1 = taskService.create(new SubTask("subtask", NEW,"1", epic1.getId()));
        SubTask subTask2 = taskService.create(new SubTask("subtask", NEW,"2", epic1.getId()));
        Epic epicN = taskService.getEpic(epic1.getId());
        SubTask subTaskN = taskService.getSubTask(subTask1.getId());

        System.out.println(subTask2);
        System.out.println(subTaskN);
        System.out.println(epicN);

        Epic epic2 = taskService.create(new Epic("epic", NEW,"1"));
        SubTask subTask3 = taskService.create(new SubTask("subtask", NEW,"1", epic2.getId()));
        Epic epicN1 = taskService.getEpic(epic2.getId());
        SubTask subTaskN1 = taskService.getSubTask(subTask3.getId());

        System.out.println("\n Пересчет всех Эпиков : \n" + taskService.getAllEpic());
        System.out.println("\n Пересчет всех Задач : \n" +  taskService.getAllTask());
        System.out.println("\n Пересчет всех Подзадач : \n" + taskService.getAllSubTask());

    }
}
