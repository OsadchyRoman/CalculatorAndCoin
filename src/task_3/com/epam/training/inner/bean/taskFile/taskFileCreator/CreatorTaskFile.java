package task_3.com.epam.training.inner.bean.taskFile.taskFileCreator;

import task_3.com.epam.training.inner.mode.modes.Mode;
import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.utils.validator.fileValidator.IFileCharacterValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatorTaskFile implements ICreator {
    private BufferedReader bufferedReader;

    public CreatorTaskFile(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public TaskFile createTaskFile(IFileCharacterValidator iFileValidator) throws IOException {
        String mode = bufferedReader.readLine();
        String capacity = bufferedReader.readLine();
        List<String> taskList = new ArrayList<>();
        String task;

        while ((task = bufferedReader.readLine()) != null) {
            taskList.add(task);
        }
        if (!iFileValidator.validateCapacity(capacity, taskList) || !iFileValidator.validateMode(mode)) {
            return null;
        }
        if (mode.toLowerCase().equals(Mode.COINS.toString().toLowerCase())) {
            if (!iFileValidator.validateOnCharacter(taskList)) {
                return null;
            }
        }

        return new TaskFile(mode, Integer.valueOf(capacity), taskList);
    }


}
