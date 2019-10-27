package supermarket.domain;

/**
 * Created by houssem89 on 27/10/2019.
 */
@FunctionalInterface
public interface Item {
    /**
     * Calculate cost.
     *
     * @return the float
     */
    Float calculateCost();
}
