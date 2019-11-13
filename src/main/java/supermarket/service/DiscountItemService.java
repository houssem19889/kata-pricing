package supermarket.service;

import supermarket.domain.ItemDiscount;
import supermarket.util.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

/**
 * Created by houssem89 on 13/11/2019.
 */
public class DiscountItemService implements IDiscountItemService {
    @Override
    public BigDecimal calculateCostItem(ItemDiscount itemDiscount) throws ParseException {
        BigDecimal result = BigDecimal.ZERO;

        if (itemDiscount.getNumber() != null) {
            BigDecimal val = new BigDecimal(itemDiscount.getNumber());
            result = itemDiscount.getQuantity().multiply(itemDiscount.getPrice().divide(val, 3, RoundingMode.HALF_UP));
        } else {
            result = itemDiscount.getQuantity().multiply(itemDiscount.getPrice());
            return result.setScale(2, RoundingMode.HALF_UP);
        }
        return Util.formateCost(result);
    }

    @Override
    public BigDecimal calculateCostByGetsFreeOne(ItemDiscount itemDiscount) {
        if (itemDiscount.getDiscountQuantity() != null && itemDiscount.getQuantity().intValue() <= itemDiscount.getDiscountQuantity().intValue()) {
            return itemDiscount.getQuantity().multiply(itemDiscount.getUnitPrice());
        } else {
            BigDecimal total = itemDiscount.getQuantity();
            BigDecimal sum = BigDecimal.ZERO;
            while (total.intValue() > 0) {
                if (total.intValue() >= itemDiscount.getDiscountQuantity().intValue()) {
                    total = BigDecimal.valueOf(total.intValue() - itemDiscount.getDiscountQuantity().intValue());
                    sum = sum.add(itemDiscount.getDiscountQuantity().multiply(itemDiscount.getUnitPrice()));
                    total = total.intValue() >= itemDiscount.getFreeQuantity().intValue() ? total.subtract(itemDiscount.getFreeQuantity()) : new BigDecimal(0);

                } else {
                    sum = sum.add(itemDiscount.getUnitPrice().multiply(total));
                    total = BigDecimal.ZERO;

                }
            }
            return sum;
        }
    }

    @Override
    public BigDecimal calculateCostByPrice(ItemDiscount itemDiscount) {
        if ((itemDiscount.getQuantity().intValue() % itemDiscount.getDiscountQuantity().intValue()) == 0) {
            return ((itemDiscount.getQuantity().divide(itemDiscount.getDiscountQuantity())).multiply(itemDiscount.getDiscountPrice()));
        } else {
            BigDecimal quantityOfNonPromotionalProduct = BigDecimal.valueOf(itemDiscount.getQuantity().intValue() % itemDiscount.getDiscountQuantity().intValue());
            BigDecimal priceOfNonPromotionalProduct = quantityOfNonPromotionalProduct.multiply(itemDiscount.getUnitPrice());
            BigDecimal priceOfPromotionalProduct = ((itemDiscount.getQuantity().subtract(quantityOfNonPromotionalProduct).divide(itemDiscount.getDiscountQuantity())).multiply(itemDiscount.getDiscountPrice()));
            return priceOfNonPromotionalProduct.add(priceOfPromotionalProduct);
        }
    }
}
