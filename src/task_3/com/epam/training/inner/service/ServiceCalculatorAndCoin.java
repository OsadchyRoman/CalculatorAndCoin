package task_3.com.epam.training.inner.service;

import task_3.com.epam.training.inner.bean.taskFile.taskFileCreator.CreatorTaskFile;
import task_3.com.epam.training.inner.bean.taskFile.taskFileCreator.ICreator;
import task_3.com.epam.training.inner.mode.modes.Mode;
import task_3.com.epam.training.inner.mode.CalculatorMode;
import task_3.com.epam.training.inner.mode.CoinsMode;
import task_3.com.epam.training.inner.mode.IMode;
import task_3.com.epam.training.inner.bean.taskFile.TaskFile;
import task_3.com.epam.training.inner.utils.writer.WriterErrorMessage;
import task_3.com.epam.training.inner.utils.writer.WriterResult;
import task_3.com.epam.training.inner.utils.validator.fileValidator.FileCharacterValidator;
import task_3.com.epam.training.inner.utils.validator.taskValidator.CalculateTaskValidator;
import task_3.com.epam.training.inner.utils.validator.taskValidator.CoinTaskValidator;

import java.io.*;

/**
 * Service for choose mode coin or
 * calculator.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */
public class ServiceCalculatorAndCoin {


    private final String pathIn;


    private final String pathOut;


    public ServiceCalculatorAndCoin(String pathIn, String pathOut) {
        this.pathIn = pathIn;
        this.pathOut = pathOut;
    }


    public String getPathIn() {
        return pathIn;
    }

    public String getPathOut() {
        return pathOut;
    }

    public void toDoWork() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathIn)));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(pathOut))))) {
            WriterErrorMessage.setPrintWriter(printWriter);
            ICreator creator = new CreatorTaskFile(bufferedReader);
            TaskFile taskFile = creator.createTaskFile(new FileCharacterValidator(new WriterErrorMessage()));
            String taskMode;
            IMode mode;

            if (taskFile != null) {
                taskMode = taskFile.getMode().toLowerCase();
                if (taskMode.equals(Mode.COINS.toString().toLowerCase())) {
                    mode = new CoinsMode(new WriterResult(), new CoinTaskValidator(new WriterErrorMessage()));
                } else {
                    mode = new CalculatorMode(new WriterResult(),
                            new CalculateTaskValidator(new WriterErrorMessage()));
                }
                mode.toDoMode(taskFile);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
