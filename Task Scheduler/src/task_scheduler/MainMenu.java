package task_scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManagerImpl();


        while (true){
            System.out.println("------------------------");
            System.out.println("TASK MANAGER");
            System.out.println("------------------------");
            System.out.println("1. Get all Tasks.");
            System.out.println("2. Add Task.");
            System.out.println("3. Get Task with highest priority.");
            System.out.println("4. Run Task.");
            System.out.println("5. Exit.");

            int choice = in.nextInt();

            switch (choice){
                case 1 -> {
                    List<Task> tasks = taskManager.getAllTasks();
                    if(tasks.isEmpty()){
                        System.out.println("No Task right now");
                    }else {
                        for (Task task : tasks){
                            System.out.println(task);
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter name: ");
                    String name = in.nextLine();
                    System.out.print("Enter priority: ");
                    int priority = in.nextInt();

                    taskManager.addTask(new Task(id, name, priority));
                }

                case 3 -> {
                    Task task = taskManager.getNextTask();
                    if(task == null){
                        System.out.println("No Task right now");
                    }else {
                        System.out.println(task);
                    }
                }

                case 5 -> {
                    System.out.println("Exiting.....");
                    return;
                }

                default -> System.out.println("Invalid Choice");
            }
        }
    }
}