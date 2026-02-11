package task_scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskManagerImpl implements TaskManager{

    private final PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(Task::getTaskPriority).reversed());
    // Can also use this instead of Compare.comparingInt
    //          |
    //          |
    //          V
    // (t1, t2) -> Integer.compare(t1.getTaskPriority(), t2.getTaskPriority())

    @Override
    public boolean addTask(Task task){
        for(Task i : queue){
            if(task.getTaskID() == i.getTaskID()){
                return false;
            }
        }
        queue.add(task);
        return true;
    }


    @Override
    public List<Task> getAllTasks(){
            return new ArrayList<>(queue);
    }

    @Override
    public Task getNextTask(){
        return queue.peek();
    }

    @Override
    public Task executeNextTask() {
        return queue.poll();
    }

}
