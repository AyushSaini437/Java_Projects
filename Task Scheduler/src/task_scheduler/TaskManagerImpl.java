import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl implements TaskManager{

    private final List<Task> taskList = new ArrayList<>();

    @Override
    public boolean addTask(Task task){
        for(Task i : taskList){
            if(task.getTaskID() == i.getTaskID()){
                return false;
            }
        }
        taskList.add(task);
        return true;
    }

    @Override
    public List<Task> getAllTasks(){
        return new ArrayList<>(taskList);
    }
}
