package supermarket;

import junit.framework.TestCase;
import org.junit.Test;
import supermarket.domain.Item;
import supermarket.service.DiscountItemByPrice;

public class DiscountItemByPriceTest extends TestCase {

    @Test
    public void testCaseQuantityMultipleOfPromotionalQuantity() {
        // Given
        Item product = new DiscountItemByPrice("chapati", 0.5f, 3, 6, 1f);
        // When
        Float sum = product.calculateCost();
        // Then
        assertEquals("3 costs 1$ and 1 costs 0.5$ then 6 costs 2 ", 2f, sum, 0f);
    }
    @Test
    public void testCaseQuantityNotMultipleOfPromotionalQuantity() {
        // Given
        Item item = new DiscountItemByPrice("Pizza", 0.5f, 3, 4, 1f);
        // When
        Float sum = item.calculateCost();
        // Then
        assertEquals("3 costs 1$ && 1  costs 0.5$  then 4 costs 1.5$ ", 1.5f, sum, 0f);
    }
}