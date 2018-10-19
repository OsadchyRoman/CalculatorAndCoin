package task_3.com.epam.training.inner;

import task_3.com.epam.training.inner.service.CreatorTaskFile;

import java.io.*;

public class Runner {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\Java\\CoinsAndCalculator\\CoinsAndCalculator\\1.txt")));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File("D:\\Java\\CoinsAndCalculator\\CoinsAndCalculator\\out.txt"))))) {
            new WriterErrorMessage(printWriter);
            CreatorTaskFile creatorTaskFile = new CreatorTaskFile(bufferedReader);
            System.out.println(creatorTaskFile.createTaskFile());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
