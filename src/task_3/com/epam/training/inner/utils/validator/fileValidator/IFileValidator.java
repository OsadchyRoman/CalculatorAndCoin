package task_3.com.epam.training.inner.utils.validator.fileValidator;

import java.util.List;

public interface IFileValidator {
    boolean validateCapacity(String capacity, List<String> tasks);
    boolean validateMode(String mode);
}
