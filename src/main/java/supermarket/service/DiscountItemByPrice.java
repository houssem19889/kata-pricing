package supermarket.service;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class DiscountItemByPrice extends DiscountItem  {
    private Float discountPrice;


    /**
     * Instantiates a new Discount item by price.
     *
     * @param name the name
     * @param unitPrice the unit price
     * @param discountQuantity the discount quantity
     * @param quantity the quantity
     * @param discountPrice the discount price
     */
    public DiscountItemByPrice(String name, Float unitPrice, Integer discountQuantity, Integer quantity, Float discountPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountQuantity = discountQuantity;
        this.quantity = quantity;
        this.discountPrice = discountPrice;
    }
    @Override
    public Float calculateCost() {
        if ((this.quantity % this.discountQuantity) == 0) {
            System.out.print("here");
            return ((this.quantity / this.discountQuantity) * this.discountPrice);
        } else {
            Integer quantityOfNonPromotionalProduct = this.quantity % this.discountQuantity;
            Float priceOfNonPromotionalProduct = quantityOfNonPromotionalProduct * this.unitPrice;
            Float priceOfPromotionalProduct =  ((this.quantity - quantityOfNonPromotionalProduct) / this.discountQuantity) * this.discountPrice;
            return priceOfNonPromotionalProduct + priceOfPromotionalProduct;
        }
    }
}
