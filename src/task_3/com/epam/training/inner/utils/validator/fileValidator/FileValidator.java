package task_3.com.epam.training.inner.utils.validator.fileValidator;

import task_3.com.epam.training.inner.mode.modes.Mode;
import task_3.com.epam.training.inner.utils.writer.IWriterErrorMessage;
import task_3.com.epam.training.inner.utils.validator.AbstractValidator;

import java.util.List;

public class FileValidator extends AbstractValidator implements IFileValidator {

    public FileValidator(IWriterErrorMessage writerErrorMessage) {
        super(writerErrorMessage);
    }

    @Override
    public boolean validateCapacity(String capacity, List<String> tasks) {
        if (!capacity.matches("\\d+") || tasks.size() != Integer.valueOf(capacity)) {
            getWriterErrorMessage().writeErrorWithFile();
            return false;
        }


        return true;
    }

    @Override
    public boolean validateMode(String mode) {
        String[] modes = Mode.getNames();
        mode = mode.toLowerCase();
        for (String checkMode : modes) {
            if (checkMode.toLowerCase().equals(mode)) {
                return true;
            }
        }
        getWriterErrorMessage().writeErrorWithFile();
        return false;
    }



}
