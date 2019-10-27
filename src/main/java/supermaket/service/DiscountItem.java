package supermaket.service;

import supermaket.domain.Item;

/**
 * Created by houssem89 on 27/10/2019.
 */
public abstract class DiscountItem implements Item {
    protected String name;
    protected Float unitPrice;
    protected Integer discountQuantity;
    protected Integer quantity;


}
