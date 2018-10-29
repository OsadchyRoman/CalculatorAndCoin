package task_3.com.epam.training.inner.bean.taskFile.taskFileCreator;

import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.utils.validator.fileValidator.IFileCharacterValidator;

import java.io.IOException;

public interface ICreator {
    TaskFile createTaskFile(IFileCharacterValidator iFileCharacterValidator) throws IOException;
}
