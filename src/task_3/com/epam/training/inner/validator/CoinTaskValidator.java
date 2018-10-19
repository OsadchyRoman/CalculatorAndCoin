package task_3.com.epam.training.inner.validator;

import task_3.com.epam.training.inner.bean.coin.Exchange;
import task_3.com.epam.training.inner.bean.coin.WaysGroup;

import java.io.FileWriter;
import java.io.IOException;

import static task_3.com.epam.training.inner.ErrorMessages.ERROR_MESSAGE_EXCHANGE;

/**
 * Class for validate task
 * from inner file.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */
public class CoinTaskValidator implements ITaskValidator {

    public CoinTaskValidator(String task, FileWriter fileWriter) {
        if (parsingParametersTask(task, fileWriter)) {
            validateCoinMode(fileWriter);
        }
    }

    public void validateCoinMode() {
        if (validateRepeatDenominationCoins(fileWriter)) {
            WaysGroup waysGroup = getAllExchanges();
            if (waysGroup.getWays().size() != 0) {
                waysGroup.printToFile(fileWriter);
            } else {
                fileWriter.write(ERROR_MESSAGE_EXCHANGE);
            }
        }
    }

    public WaysGroup getAllExchanges() {
        Exchange exchange = new Exchange(sumForExchange, denominationСoins);
        return exchange.getAllExchanges();
    }


    public boolean validateRepeatDenominationCoins() {
        int sumRepeat = 0;
        for (int i = 0; i < denominationСoins.length; i++) {
            for (int j = i + 1; j < denominationСoins.length; j++) {
                if (denominationСoins[i] == denominationСoins[j]) {
                    sumRepeat++;
                }
            }
        }
        if (sumRepeat != 0) {
            fileWriter.write(ERROR_MESSAGE_EXPRESSION);
            return false;
        }
        return true;
    }

    public boolean parsingParametersTask(String task){
        if ("".equals(task) || !task.matches("(\\d+\\s)+[\\d]+")) {
            fileWriter.write(ERROR_MESSAGE_EXPRESSION);
            return false;
        }
        int i = 0;
        sumForExchange = Integer.parseInt(task.substring(0, task.indexOf(" ")));
        task = task.substring(task.indexOf(" ") + 1, task.length());
        denominationСoins = new int[task.split(" ").length];
        for (String coin : task.split(" ")) {
            denominationСoins[i++] = Integer.parseInt(coin);
        }
        return true;
    }

    @Override
    public boolean validateTask(String task) {
        return false;
    }
}
