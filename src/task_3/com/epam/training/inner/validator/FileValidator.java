package task_3.com.epam.training.inner.validator;

import task_3.com.epam.training.inner.Mode;
import task_3.com.epam.training.inner.WriterErrorMessage;

import java.util.Arrays;
import java.util.List;

public class FileValidator implements IFileValidator {


    @Override
    public boolean validateOnCharacter(List<String> tasks) {
        for (String task : tasks) {
            if (task.matches("[\\d\\s]*$")){
                WriterErrorMessage.writeErrorWithFile();
            }
        }
        return true;
    }

    @Override
    public boolean validateCapacity(String capacity, List<String> tasks) {
        if (!capacity.matches("\\d+") || tasks.size() - 1 != Integer.valueOf(capacity)) {
            WriterErrorMessage.writeErrorWithFile();
            return false;
        }


        return true;
    }

    @Override
    public boolean validateMode(String mode) {
        String modes = Arrays.toString(Mode.values()).toLowerCase();
        mode = mode.toLowerCase();
        for (String checkMode : modes.split(" ")) {
            if (checkMode.equals(mode)) {
                return true;
            }
        }
        WriterErrorMessage.writeErrorWithFile();
        return false;
    }
}
