package task_3.com.epam.training.inner.utils.validator;

import task_3.com.epam.training.inner.utils.writer.IWriterErrorMessage;

public abstract class AbstractValidator {

    private IWriterErrorMessage writerErrorMessage;

    public AbstractValidator(IWriterErrorMessage writerErrorMessage) {
        this.writerErrorMessage = writerErrorMessage;
    }

    public IWriterErrorMessage getWriterErrorMessage() {
        return writerErrorMessage;
    }

    public void setWriterErrorMessage(IWriterErrorMessage writerErrorMessage) {
        this.writerErrorMessage = writerErrorMessage;
    }

}
