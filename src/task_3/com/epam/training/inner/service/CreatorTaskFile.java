package task_3.com.epam.training.inner.service;

import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.validator.FileValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatorTaskFile {
    private BufferedReader bufferedReader;

    public CreatorTaskFile(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public TaskFile createTaskFile() throws IOException {
        FileValidator fileValidator = new FileValidator();
        String mode = bufferedReader.readLine();
        String capacity = bufferedReader.readLine();


        List<String> taskList = new ArrayList<>();
        String task;
        while ((task = bufferedReader.readLine()) != null) {
            taskList.add(task);
        }


        if (!fileValidator.validateCapacity(capacity, taskList) || !fileValidator.validateMode(mode)) {
            return null;
        }

        return new TaskFile(mode, Integer.valueOf(capacity), taskList);
    }

}
