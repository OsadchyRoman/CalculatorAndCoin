package task_3.com.epam.training.inner.utils.writer;

public interface IWriterResult extends IWriter {
    void writelnSolution(String solution);
    void writelnMode(String mode);
    void writelnCapacity(int capacity);
    void writeSolution(String solution);
    void writeMode(String mode);
    void writeCapacity(int capacity);
}
