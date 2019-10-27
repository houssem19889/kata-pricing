package supermarket.service;

import supermarket.Exception.IllegalConversionException;
import supermarket.domain.WeightPrice;
import supermarket.domain.WeightUnit;
import supermarket.util.Util;

import static supermarket.util.UnitConvert.getConvertorFunction;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class WeightPriceService {
    /**
     * Gets single price.
     *
     * @param weightPrice the weight price
     * @param quantity the quantity
     * @param unit the unit
     * @return the single price
     * @throws IllegalConversionException the illegal conversion exception
     */
    public static float getSinglePrice(WeightPrice weightPrice, Float quantity, WeightUnit unit) throws IllegalConversionException {
        return Util.formateCost(weightPrice.getPrice() * getConvertorFunction(unit, weightPrice.getUnit()).apply(quantity));
    }

    /**
     * Gets discount price.
     *
     * @param weightPrice the weight price
     * @param quantity the quantity
     * @param unit the unit
     * @param priceDiscount the price discount
     * @param quantityDiscount the quantity discount
     * @return the discount price
     * @throws IllegalConversionException the illegal conversion exception
     */
    public static float getDiscountPrice(WeightPrice weightPrice, Float quantity, WeightUnit unit, Float priceDiscount,Float quantityDiscount) throws IllegalConversionException {
        Float realQuantity = getConvertorFunction(unit, weightPrice.getUnit()).apply(quantity);
        if (realQuantity < quantityDiscount) {
            return getSinglePrice(weightPrice, quantity, unit);
        }

        int div = (int) (realQuantity / quantityDiscount);
        int rest = (int) (realQuantity % quantityDiscount);
        return Util.formateCost(div * priceDiscount + rest * weightPrice.getPrice());
    }
}
