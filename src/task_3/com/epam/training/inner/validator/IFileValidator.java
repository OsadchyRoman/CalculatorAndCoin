package task_3.com.epam.training.inner.validator;

import java.util.List;

public interface IFileValidator {
    boolean validateOnCharacter(List<String> task);
    boolean validateCapacity(String capacity, List<String> tasks);
    boolean validateMode(String mode);
}
