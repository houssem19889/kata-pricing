package supermarket.service;

import supermarket.domain.ItemDiscount;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by houssem89 on 13/11/2019.
 */
public interface IDiscountItemService {
    /**
     * Calculate cost item.
     *
     * @param itemDiscount the item discount
     * @return the big decimal
     * @throws ParseException the parse exception
     */
    public BigDecimal calculateCostItem(ItemDiscount itemDiscount) throws ParseException;

    /**
     * Calculate cost by gets free one.
     *
     * @param itemDiscount the item discount
     * @return the big decimal
     */
    public BigDecimal calculateCostByGetsFreeOne(ItemDiscount itemDiscount);

    /**
     * Calculate cost by price.
     *
     * @param itemDiscount the item discount
     * @return the big decimal
     */
    public BigDecimal calculateCostByPrice(ItemDiscount itemDiscount);
}
