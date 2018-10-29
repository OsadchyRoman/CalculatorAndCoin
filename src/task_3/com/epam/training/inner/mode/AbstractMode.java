package task_3.com.epam.training.inner.mode;

import task_3.com.epam.training.inner.utils.writer.IWriterResult;
import task_3.com.epam.training.inner.utils.validator.taskValidator.ITaskValidator;

public abstract class AbstractMode implements IMode{
    private IWriterResult writerResult;

    private ITaskValidator taskValidator;

    public AbstractMode(IWriterResult writerResult, ITaskValidator taskValidator) {
        this.writerResult = writerResult;
        this.taskValidator = taskValidator;
    }

    public IWriterResult getWriterResult() {
        return writerResult;
    }

    public void setWriterResult(IWriterResult writerResult) {
        this.writerResult = writerResult;
    }

    public ITaskValidator getTaskValidator() {
        return taskValidator;
    }

    public void setTaskValidator(ITaskValidator taskValidator) {
        this.taskValidator = taskValidator;
    }
}
