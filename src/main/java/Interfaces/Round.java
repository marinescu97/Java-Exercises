package Interfaces;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This interface is used to round numbers.
 */
public interface Round {
    /**
     * Rounds a number to the given decimal places.
     * @param value the number to round
     * @param places the number places to round
     * @return the rounded number
     */
     default double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
