package task_scheduler;

import java.util.List;

public interface TaskManager {

    List<Task> getAllTasks();

    boolean addTask(Task task);

    Task getNextTask();

    Task executeNextTask();
}
