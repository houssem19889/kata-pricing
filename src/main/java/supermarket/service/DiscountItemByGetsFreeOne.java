package supermarket.service;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class DiscountItemByGetsFreeOne extends DiscountItem {

    private Integer freeQuantity;


    /**
     * Instantiates a new Discount item by gets free one.
     *
     * @param name the name
     * @param unitPrice the unit price
     * @param discountQuantity the discount quantity
     * @param quantity the quantity
     * @param freeQuantity the free quantity
     */
    public DiscountItemByGetsFreeOne(String name, Float unitPrice, Integer discountQuantity, Integer quantity, Integer freeQuantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountQuantity = discountQuantity;
        this.quantity = quantity;
        this.freeQuantity = freeQuantity;
    }

    /**
     * Gets free quantity.
     *
     * @return the free quantity
     */
    public Integer getFreeQuantity() {
        return freeQuantity;
    }

    @Override
    public Float calculateCost() {
        if (this.discountQuantity != null && this.quantity <= this.discountQuantity) {
            return this.quantity * this.unitPrice;
        } else {
            Integer total = this.quantity;
            Float sum = 0f;
            while (total > 0) {
                if (total >= this.discountQuantity) {
                    total = total - this.discountQuantity;
                    sum = sum + (this.discountQuantity * this.unitPrice);
                    total = (total >= this.freeQuantity ? total = total - this.freeQuantity : 0);

                } else {
                    sum = sum + (this.getUnitPrice() * total);
                    total = 0;

                }
            }
            return sum;
        }
    }
}