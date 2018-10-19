package task_3.com.epam.training.inner.bean.coin;

/**
 * Class for exchange sum coin where
 * {@code sumForExchange} sum coin
 * {@code denominationCoins} coin for denomination
 *
 * @version 2.1
 * @autor Asadchy Raman
 */

public class Exchange {
    /**
     * Sum for exchange
     */
    private final int sumForExchange;

    /**
     * Coin for denomination {@code sumForExchange}
     */
    private final int[] denominationСoins;

    /**
     * Initializes a newly created {@code Exchange} object.
     *
     * @param sumForExchange    A {@code int}
     * @param denominationСoins A {@code int[]}
     */
    public Exchange(final int sumForExchange, final int... denominationСoins) {
        this.denominationСoins = denominationСoins;
        this.sumForExchange = sumForExchange;
    }

    /**
     * Return new object {@link WaysGroup} with all
     * exchanges groups.
     *
     * @return New object {@link WaysGroup}
     */
    public WaysGroup getAllExchanges() {
        int[] coins = denominationСoins;
        WaysGroup[][] waysGroups = new WaysGroup[coins.length][sumForExchange + 1];
        waysGroups[0][0] = new WaysGroup();
        waysGroups[0][0].add(new Way());
        for (int i = 0; i < sumForExchange; i++) {
            for (int j = 0; j < coins.length; j++) {
                for (int k = j; k < coins.length; k++) {
                    if (i + coins[k] <= sumForExchange) {
                        if (waysGroups[k][i + coins[k]] == null) {
                            waysGroups[k][i + coins[k]] = new WaysGroup();
                        }
                        waysGroups[k][i + coins[k]].add(waysGroups[j][i]);
                    }
                }
                if (i + coins[j] <= sumForExchange) {
                    waysGroups[j][i + coins[j]].add(coins[j]);
                }
                waysGroups[j][i] = null;
            }
        }
        WaysGroup result = new WaysGroup();
        for (int i = 0; i < coins.length; i++) {
            result.add(waysGroups[i][sumForExchange]);
        }
        return result;
    }
}
