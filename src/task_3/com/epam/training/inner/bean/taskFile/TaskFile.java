package task_3.com.epam.training.inner.bean.taskFile;

import java.util.List;

public class TaskFile {
    private String mode;
    private int capacity;
    private List<String> taskList;

    public TaskFile(String mode, int capacity, List<String> taskList) {
        this.mode = mode;
        this.capacity = capacity;
        this.taskList = taskList;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "TaskFile{" +
                "mode='" + mode + '\'' +
                ", capacity=" + capacity +
                ", taskList=" + taskList +
                '}';
    }
}
