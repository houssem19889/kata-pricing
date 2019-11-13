package supermarket.service;

import supermarket.Exception.IllegalConversionException;
import supermarket.domain.WeightPrice;
import supermarket.domain.WeightUnit;
import supermarket.util.Util;

import java.math.BigDecimal;
import java.text.ParseException;

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
     * @throws IllegalConversionException the illegal conversion exception
     */
    public static BigDecimal getSinglePrice(WeightPrice weightPrice, BigDecimal quantity, WeightUnit unit) throws IllegalConversionException, ParseException {
        return Util.formateCost((weightPrice.getPrice().multiply(getConvertorFunction(unit, weightPrice.getUnit()).apply(quantity))));
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
     * @throws IllegalConversionException the illegal conversion exception
     */
    public static BigDecimal getDiscountPrice(WeightPrice weightPrice, BigDecimal quantity, WeightUnit unit, BigDecimal priceDiscount, BigDecimal quantityDiscount) throws IllegalConversionException, ParseException {
        BigDecimal realQuantity = getConvertorFunction(unit, weightPrice.getUnit()).apply(quantity);
        if (realQuantity.intValue() < quantityDiscount.intValue()) {
            return getSinglePrice(weightPrice, quantity, unit);
        }
        BigDecimal div = (realQuantity.divide(quantityDiscount));
        BigDecimal rest = BigDecimal.valueOf((realQuantity.intValue() % quantityDiscount.intValue()));
        return Util.formateCost((div.multiply(priceDiscount)).add(rest.multiply(weightPrice.getPrice())));
    }
}
