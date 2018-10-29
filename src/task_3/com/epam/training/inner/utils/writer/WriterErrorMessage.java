package task_3.com.epam.training.inner.utils.writer;


import task_3.com.epam.training.inner.utils.writer.messages.ErrorMessages;

public class WriterErrorMessage extends AbstractWriter implements IWriterErrorMessage {

    @Override
    public void writeErrorWithFile() {
        write(ErrorMessages.ERROR_MESSAGE_FILE);
    }

    @Override
    public void writeErrorWithBrackets() {
        write(ErrorMessages.ERROR_MESSAGE_BRACKET);
    }

    @Override
    public void writeErrorWithExpression() {
        write(ErrorMessages.ERROR_MESSAGE_EXPRESSION);
    }

    @Override
    public void writeErrorWithExchange() {
        write(ErrorMessages.ERROR_MESSAGE_EXCHANGE);
    }
}
