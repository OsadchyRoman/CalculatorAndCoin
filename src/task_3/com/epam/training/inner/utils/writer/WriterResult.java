package task_3.com.epam.training.inner.utils.writer;

public class WriterResult extends AbstractWriter implements IWriterResult {

    @Override
    public void writelnSolution(String solution) {
        writeln(solution);
    }

    @Override
    public void writelnMode(String mode) {
        writeln(mode);
    }

    @Override
    public void writelnCapacity(int capacity) {
        writeln(capacity);
    }

    @Override
    public void writeSolution(String solution) {
        write(solution);
    }

    @Override
    public void writeMode(String mode) {
        write(mode);
    }

    @Override
    public void writeCapacity(int capacity) {
        writeln(capacity);
    }
}
