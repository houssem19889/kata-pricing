package supermarket.service;

import supermarket.domain.Item;

/**
 * Created by houssem89 on 27/10/2019.
 */
public abstract class DiscountItem implements Item {
    protected String name;
    protected Float unitPrice;
    protected Integer discountQuantity;
    protected Integer quantity;

    public String getName() {
        return name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public Integer getDiscountQuantity() {
        return discountQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
