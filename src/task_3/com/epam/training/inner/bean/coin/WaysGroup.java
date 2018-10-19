package task_3.com.epam.training.inner.bean.coin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code WaysGroup} class represents
 * list {@link Way} objects. Actually this container
 * for all way groups after exchange.
 */
public class WaysGroup {
    /**
     * The value is used for {@link Way} storage.
     */
    private final List<Way> ways;

    /**
     * Initializes a newly created {@code WaysGroup} object.
     */
    public WaysGroup() {
        ways = new ArrayList<>();
    }

    /**
     * Get method for take the field {@code ways}
     *
     * @return List objects {@link Way}
     */
    public List<Way> getWays() {
        return ways;
    }

    /**
     * Method for added new object {@code Way}
     * in list.
     *
     * @param way new object {@link Way}
     */
    public void add(Way way) {
        ways.add(way);
    }

    /**
     * Method for added coin in {@code Way}
     *
     * @param coin int coin
     */
    public void add(int coin) {
        for (Way way : ways) {
            way.add(coin);
        }
    }

    /**
     * Method for added new object {@link WaysGroup}
     *
     * @param group new object {@link WaysGroup}
     */
    public void add(WaysGroup group) {
        if (group == null) {
            return;
        }
        for (Way way : group.ways) {
            ways.add(new Way(way));
        }
    }

    /**
     * Method for print all way in list ways
     */
    public void print() {
        for (Way way : ways) {
            way.print();
        }
    }
}
