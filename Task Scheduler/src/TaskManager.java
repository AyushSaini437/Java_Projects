import java.util.List;

public interface TaskManager {

    List<Task> getAllTasks();

    boolean addTask(Task task);
}
