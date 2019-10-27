package supermarket.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class Util {
    /**
     * Formate cost.
     *
     * @param cost the cost
     * @return the float
     */
    public static Float formateCost (Float cost) {
        DecimalFormat df = new DecimalFormat("####0.00");
        df.setRoundingMode(RoundingMode.CEILING);
        return Float.parseFloat(df.format(cost).replace(',', '.'));
    }
}
