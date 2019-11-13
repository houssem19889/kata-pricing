package supermarket.domain;

import java.math.BigDecimal;

/**
 * Created by houssem89 on 13/11/2019.
 */
public class ItemDiscount {
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
    private Integer number;
    private BigDecimal unitPrice;
    private BigDecimal discountQuantity;
    private BigDecimal freeQuantity;
    private BigDecimal discountPrice;

    /**
     * Instantiates a new Item discount.
     *
     * @param name the name
     * @param price the price
     * @param quantity the quantity
     */
    public ItemDiscount(String name, BigDecimal price, BigDecimal quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Item discount.
     *
     * @param name the name
     * @param quantity the quantity
     * @param price the price
     * @param number the number
     */
    public ItemDiscount(String name, BigDecimal quantity, BigDecimal price, Integer number) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.number = number;
    }

    /**
     * Instantiates a new Item discount.
     *
     * @param name the name
     * @param unitPrice the unit price
     * @param discountQuantity the discount quantity
     * @param quantity the quantity
     * @param freeQuantity the free quantity
     * @param discountPrice the discount price
     */
    public ItemDiscount(String name, BigDecimal unitPrice, BigDecimal discountQuantity, BigDecimal quantity, BigDecimal freeQuantity, BigDecimal discountPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountQuantity = discountQuantity;
        this.quantity = quantity;
        this.freeQuantity = freeQuantity;
        this.discountPrice = discountPrice;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Gets discount quantity.
     *
     * @return the discount quantity
     */
    public BigDecimal getDiscountQuantity() {
        return discountQuantity;
    }

    /**
     * Gets free quantity.
     *
     * @return the free quantity
     */
    public BigDecimal getFreeQuantity() {
        return freeQuantity;
    }

    /**
     * Gets discount price.
     *
     * @return the discount price
     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }


}
