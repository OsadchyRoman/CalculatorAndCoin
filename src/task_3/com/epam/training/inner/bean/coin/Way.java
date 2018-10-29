package task_3.com.epam.training.inner.bean.coin;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code WaysGroup} class represents
 * coins.
 *
 * @version 2.1
 * @autor Asadchy Raman
 */
public class Way {
    /**
     * The value is used for coins storage.
     */
    private final Integer[] coins;

    /**
     * Initializes a newly created {@code Way} object.
     */
    public Way() {
        coins = new Integer[0];
    }

    /**
     * Initializes a newly created {@code Way} object.
     *
     * @param way Object {@code Way}
     */
    public Way(Way way) {
        coins = new Integer[way.coins.length + 1];
        System.arraycopy(way.coins, 0, coins, 0, way.coins.length);
    }

    public Integer[] getCoins() {
        return coins;
    }

    /**
     * Method for added coin in {@code coins}
     *
     * @param coin Int new coin
     */
    public void add(int coin) {
        coins[coins.length - 1] = coin;
    }

    /**
     * Method for print all coin in array coins
     */
    public void print() {
        for (int i = 0; i < coins.length - 1; i++) {
            System.out.print(coins[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder wayString = new StringBuilder();

        for (int i = 0; i < coins.length - 1; i++) {
            wayString.append(coins[i]).append(" ");
        }

        return wayString.toString();
    }
}
