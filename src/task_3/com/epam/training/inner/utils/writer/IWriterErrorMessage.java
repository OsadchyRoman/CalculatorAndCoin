package task_3.com.epam.training.inner.utils.writer;

public interface IWriterErrorMessage extends IWriter {
    void writeErrorWithFile();
    void writeErrorWithBrackets();
    void writeErrorWithExpression();
    void writeErrorWithExchange();
}
