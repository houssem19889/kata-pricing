package supermarket.service;

import supermarket.domain.Item;

/**
 * Created by houssem89 on 27/10/2019.
 */
public abstract class DiscountItem implements Item {
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Unit price.
     */
    protected Float unitPrice;
    /**
     * The Discount quantity.
     */
    protected Integer discountQuantity;
    /**
     * The Quantity.
     */
    protected Integer quantity;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public Float getUnitPrice() {
        return unitPrice;
    }

    /**
     * Gets discount quantity.
     *
     * @return the discount quantity
     */
    public Integer getDiscountQuantity() {
        return discountQuantity;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }
}
