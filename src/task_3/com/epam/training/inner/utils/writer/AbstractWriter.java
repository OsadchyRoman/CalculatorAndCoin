package task_3.com.epam.training.inner.utils.writer;

import java.io.PrintWriter;

public abstract class AbstractWriter implements IWriter {

    private static PrintWriter printWriter;

    public static PrintWriter getPrintWriter() {
        return printWriter;
    }

    public static void setPrintWriter(PrintWriter printWriter) {
        AbstractWriter.printWriter = printWriter;
    }

    @Override
    public void writeln(String string) {
        printWriter.println(string);
    }

    @Override
    public void write(String string) {
        printWriter.print(string);
    }

    @Override
    public void writeln(int value) {
        printWriter.println(value);
    }

    @Override
    public void writeNewLine(){
        printWriter.write("\n");
    }


}
