public class Task {
    private int taskID;
    private String taskName;
    private int taskPriority;

    public Task(int taskID, String taskName, int taskPriority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
    }

    public Task(){

    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String  toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", taskPriority=" + taskPriority +
                '}';
    }
}
