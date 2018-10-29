package task_3.com.epam.training.inner.mode;

import task_3.com.epam.training.inner.bean.coin.Way;
import task_3.com.epam.training.inner.bean.coin.WaysGroup;
import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.utils.writer.IWriterResult;
import task_3.com.epam.training.inner.utils.validator.taskValidator.ITaskValidator;

import java.util.Collections;
import java.util.List;

import static task_3.com.epam.training.inner.utils.ParsingTaskCoin.*;

public class CoinsMode extends AbstractMode implements IMode {

    public CoinsMode(IWriterResult writerResult, ITaskValidator taskValidator) {
        super(writerResult, taskValidator);
    }

    @Override
    public void toDoMode(TaskFile taskFile) {
        ITaskValidator taskValidator = getTaskValidator();
        List<String> taskList = taskFile.getTaskList();
        String mode = taskFile.getMode();
        IWriterResult writerResult = getWriterResult();

        writerResult.writelnMode(mode);
        if (!taskList.isEmpty()) {
            for (String task : taskList) {
                writerResult.writeNewLine();
                if (taskValidator.validateTask(task)) {
                    int sumForExchange = getSumForExchange(task);
                    int[] denominationСoins = getDenominationCoins(task.substring(task.indexOf(" ") + 1,
                            task.length()));
                    WaysGroup waysGroup = getAllExchanges(sumForExchange, denominationСoins);
                    List<Way> wayList = waysGroup.getWays();

                    Collections.reverse(wayList);
                    for (Way way : wayList) {
                        if (way.equals(wayList.get(wayList.size() - 1))) {
                            writerResult.writeSolution(way.toString());
                        } else {
                            writerResult.writelnSolution(way.toString());
                        }
                    }
                }
                if (!task.equals(taskList.get(taskList.size() - 1))) {
                    writerResult.writeNewLine();
                }
            }
        }


    }
}
