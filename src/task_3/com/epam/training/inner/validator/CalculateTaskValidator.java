package task_3.com.epam.training.inner.validator;

import task_3.com.epam.training.inner.WriterErrorMessage;

/**
 * Class for validate expression
 * from inner file.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */

public class CalculateTaskValidator implements ITaskValidator {

    @Override
    public boolean validateTask(String task) {
        return validateBrackets(task) && validateSign(task) && validateSymbol(task);
    }

    private boolean validateBrackets(String task){
        int openBrackets = 0;
        int closeBrackets = 0;
        for (char element : task.toCharArray()) {
            if (element == '(') {
                openBrackets++;
            }
            if (element == ')') {
                closeBrackets++;
            }
        }
        if (openBrackets != closeBrackets) {
            WriterErrorMessage.writeErrorWithBrackets();
            return false;
        }
        return true;
    }

    private boolean validateSymbol(String task) {
        if (!task.matches("[\\d\\s+()*/-]*$")) {
            WriterErrorMessage.writeErrorWithExpression();
            return false;
        }
        return true;
    }

    private boolean validateSign(String task) {
        String s = task.replaceAll(" ", "");
        char[] a = s.toCharArray();
        boolean validate = true;
        for (int i = 0; i < s.length(); i++) {
            if (a[i] == '-') {
                if (i == 0) {
                    validate = false;
                }
                if (i == s.length() - 1) {
                    validate = false;
                }
                if (a[i - 1] == '(' && !Character.isDigit(a[i - 1]) ||
                        !Character.isDigit(a[i + 1]) && a[i + 1] == ')') {
                    validate = false;
                }
            }
            if (a[i] == '(' && a[i + 1] == ')') {
                validate = false;
            }
            if ((a[i] == '+' || a[i] == '*' || a[i] == '/' || a[i] == '-') && (a[i] == a[i + 1] ||
                    a[i + 1] == '+' || a[i + 1] == '*' || a[i + 1] == '/' || a[i + 1] == '-')) {
                validate = false;
            }
        }
        if (!validate) {
            WriterErrorMessage.writeErrorWithExpression();
        }
        return validate;
    }

}
