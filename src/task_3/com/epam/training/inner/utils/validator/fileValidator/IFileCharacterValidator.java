package task_3.com.epam.training.inner.utils.validator.fileValidator;

import java.util.List;

public interface IFileCharacterValidator extends IFileValidator{
    boolean validateOnCharacter(List<String> tasks);
}
