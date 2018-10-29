package task_3.com.epam.training.inner.mode.modes;

import java.util.Arrays;

public enum Mode {
    CALCULATOR, COINS;

    public static String[] getNames() {
        return Arrays.toString(Mode.values()).replaceAll("^.|.$", "").split(", ");
    }
}
