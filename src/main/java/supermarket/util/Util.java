package supermarket.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class Util {
    /**
     * Formate cost.
     *
     * @param cost the cost
     * @return the float
     * @throws ParseException the parse exception
     */
    public static BigDecimal formateCost(BigDecimal cost) throws ParseException {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("####.##", formatSymbols);
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(5);
        BigDecimal val = cost.setScale(2, BigDecimal.ROUND_UP);
        return (new BigDecimal(df.format(val)));
    }
}
