package task_3.com.epam.training.inner.utils;

import task_3.com.epam.training.inner.bean.coin.Exchange;
import task_3.com.epam.training.inner.bean.coin.WaysGroup;

public class ParsingTaskCoin {


    public static WaysGroup getAllExchanges(int sumForExchange, int[] denominationСoins) {
        Exchange exchange = new Exchange(sumForExchange, denominationСoins);

        return exchange.getAllExchanges();
    }

    public static int[] getDenominationCoins(String task) {
        int i = 0;
        int[] denominationСoins = new int[task.split(" ").length];

        for (String coin : task.split(" ")) {
            denominationСoins[i++] = Integer.parseInt(coin);
        }

        return denominationСoins;
    }

    public static int getSumForExchange(String task) {
        return Integer.parseInt(task.substring(0, task.indexOf(" ")));
    }
}
