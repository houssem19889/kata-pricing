package supermarket.service;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class DiscountItemByGetsFreeOne extends DiscountItem {

    private Integer freeQuantity;


    public DiscountItemByGetsFreeOne(String name, Float unitPrice, Integer discountQuantity, Integer quantity, Integer freeQuantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountQuantity = discountQuantity;
        this.quantity = quantity;
        this.freeQuantity = freeQuantity;
    }

    public Integer getFreeQuantity() {
        return freeQuantity;
    }

    @Override
    public Float calculateCost() {
        if (this.discountQuantity != null && this.quantity <= this.discountQuantity) {
            return this.quantity * this.unitPrice;
        } else {
            Integer total = this.quantity;
            Float cost = 0f;
            while (total > 0) {
                if (total >= this.discountQuantity) {
                    total = total - this.discountQuantity;
                    cost = cost + (this.discountQuantity * this.unitPrice);
                    total = (total >= this.freeQuantity ? total = total - this.freeQuantity : 0);
                } else {
                    cost = cost + (this.getUnitPrice() * total);
                    total = 0;
                }
            }
            return cost;
        }
    }
}