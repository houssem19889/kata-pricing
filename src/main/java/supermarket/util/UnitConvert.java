package supermarket.util;

import supermarket.Exception.IllegalConversionException;
import supermarket.domain.WeightUnit;

import java.util.function.Function;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class UnitConvert {
    /**
     * Gets convertor function.
     *
     * @param inputUnit the input unit
     * @param outputUnit the output unit
     * @return the convertor function
     * @throws IllegalConversionException the illegal conversion exception
     */
    public  static Function<Float, Float> getConvertorFunction(WeightUnit inputUnit, WeightUnit outputUnit) throws IllegalConversionException {
        if (inputUnit == null) {
            throw new NullPointerException("input unit shouldn't be null.");
        }
        if (outputUnit == null) {
            throw new NullPointerException("output unit shouldn't be null.");
        }
        if (outputUnit == inputUnit) {
            return weight -> weight;
        }
        switch (inputUnit) {
            case OUNCE:
                return weight -> weight / 16;
            case POUND:
                return weight -> weight * 16;
            default:
                throw new IllegalConversionException("exception to convert");
        }

    }
}
