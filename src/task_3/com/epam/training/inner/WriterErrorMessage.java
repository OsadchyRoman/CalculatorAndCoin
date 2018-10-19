package task_3.com.epam.training.inner;

import java.io.PrintWriter;

public class WriterErrorMessage {

    public static PrintWriter printWriter;

    public WriterErrorMessage(PrintWriter printWriter) {
        WriterErrorMessage.printWriter = printWriter;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        WriterErrorMessage.printWriter = printWriter;
    }

    public static void writeErrorWithFile() {
        printWriter.println(ErrorMessages.ERROR_MESSAGE_FILE);
    }

    public static void writeErrorWithBrackets() { printWriter.println(ErrorMessages.ERROR_MESSAGE_BRACKET); }

    public static void writeErrorWithExpression() {
        printWriter.println(ErrorMessages.ERROR_MESSAGE_EXPRESSION);
    }
}
