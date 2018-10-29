package task_3.com.epam.training.inner.utils.validator.fileValidator;

import task_3.com.epam.training.inner.utils.writer.IWriterErrorMessage;

import java.util.List;

public class FileCharacterValidator extends FileValidator implements IFileCharacterValidator {

    public FileCharacterValidator(IWriterErrorMessage writerErrorMessage) {
        super(writerErrorMessage);
    }

    @Override
    public boolean validateOnCharacter(List<String> tasks) {
        for (String task : tasks) {
            if (!task.matches("[\\d\\s]*$")){
                getWriterErrorMessage().writeErrorWithFile();
                return false;
            }
        }
        return true;
    }
}
