package supermarket.domain;

import java.math.BigDecimal;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class WeightPrice {
    private final BigDecimal price;
    private final WeightUnit unit;

    /**
     * Instantiates a new Weight price.
     *
     * @param price the price
     * @param unit the unit
     */
    public WeightPrice(BigDecimal price, WeightUnit unit) {
        this.price = price;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeightPrice)) return false;

        WeightPrice that = (WeightPrice) o;

        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (unit != that.unit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
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
     * Gets unit.
     *
     * @return the unit
     */
    public WeightUnit getUnit() {
        return unit;
    }
}
