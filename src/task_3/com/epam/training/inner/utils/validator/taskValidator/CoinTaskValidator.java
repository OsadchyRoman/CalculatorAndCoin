package task_3.com.epam.training.inner.utils.validator.taskValidator;

import task_3.com.epam.training.inner.bean.coin.Way;
import task_3.com.epam.training.inner.bean.coin.WaysGroup;
import task_3.com.epam.training.inner.utils.writer.IWriterErrorMessage;
import task_3.com.epam.training.inner.utils.validator.AbstractValidator;

import java.util.List;

import static task_3.com.epam.training.inner.utils.ParsingTaskCoin.*;

/**
 * Class for validate task
 * from inner file.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */
public class CoinTaskValidator extends AbstractValidator implements ITaskValidator {

    public CoinTaskValidator(IWriterErrorMessage writerErrorMessage) {
        super(writerErrorMessage);
    }

    @Override
    public boolean validateTask(String task) {
        if (validateFormatTask(task)) {
            int sumForExchange = getSumForExchange(task);
            int[] denominationСoins = getDenominationCoins(task.substring(task.indexOf(" ") + 1, task.length()));
            WaysGroup waysGroup = getAllExchanges(sumForExchange, denominationСoins);


            if (!validateRepeatDenominationCoins(denominationСoins) ||
                    !validateOpportunityExchange(waysGroup.getWays())) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }


    private boolean validateRepeatDenominationCoins(int[] denominationСoins) {
        int sumRepeat = 0;

        for (int i = 0; i < denominationСoins.length; i++) {
            for (int j = i + 1; j < denominationСoins.length; j++) {
                if (denominationСoins[i] == denominationСoins[j]) {
                    sumRepeat++;
                }
            }
        }
        if (sumRepeat != 0) {
            getWriterErrorMessage().writeErrorWithExpression();
            return false;
        }

        return true;
    }

    private boolean validateFormatTask(String task) {
        if ("".equals(task) || !task.matches("(\\d+\\s)+[\\d]+")) {
            getWriterErrorMessage().writeErrorWithExpression();
            return false;
        }

        return true;
    }

    private boolean validateOpportunityExchange(List<Way> wayList) {
        if (wayList.isEmpty()) {
            getWriterErrorMessage().writeErrorWithExchange();
            return false;
        }
        return true;
    }
}
