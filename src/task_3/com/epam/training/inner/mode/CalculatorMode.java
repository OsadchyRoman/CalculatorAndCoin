package task_3.com.epam.training.inner.mode;

import task_3.com.epam.training.inner.bean.calculator.Calculator;
import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.utils.writer.IWriterResult;
import task_3.com.epam.training.inner.utils.validator.taskValidator.ITaskValidator;

import java.util.List;

public class CalculatorMode extends AbstractMode implements IMode {

    public CalculatorMode(IWriterResult writerResult, ITaskValidator taskValidator) {
        super(writerResult, taskValidator);
    }

    @Override
    public void toDoMode(TaskFile taskFile) {
        Calculator calculator = new Calculator();
        ITaskValidator taskValidator = getTaskValidator();
        String mode = taskFile.getMode();
        int capacity = taskFile.getCapacity();
        IWriterResult writerResult = getWriterResult();

        writerResult.writelnMode(mode);
        writerResult.writelnCapacity(capacity);
        if (!taskFile.getTaskList().isEmpty()) {
            List<String> taskList = taskFile.getTaskList();
            String lastTask = taskList.get(taskList.size() - 1);
            for (String task : taskList) {
                if (taskValidator.validateTask(task)) {
                    String opn = calculator.getNotation(task);
                    Double result = calculator.calculateResult(opn);
                    if (task.equals(lastTask)) {
                        writerResult.writeSolution(result.toString());
                    } else {
                        writerResult.writelnSolution(result.toString());
                    }
                }
            }
        }
    }
}
