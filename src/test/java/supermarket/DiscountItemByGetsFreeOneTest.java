package supermarket;

import junit.framework.TestCase;
import org.junit.Test;
import supermarket.domain.Item;
import supermarket.service.DiscountItemByGetsFreeOne;

public class DiscountItemByGetsFreeOneTest extends TestCase {

    @Test
    public void testDiscountWithQuantity() {
        // Given
        Item item = new DiscountItemByGetsFreeOne("Chocolat", 1f,5, 3, 2);
        // When
        Float sum = item.calculateCost();
        // Then
        assertEquals("1 costs 1$ && by 5 getting 2 free then 3 for 3$ ", 3f, sum, 0f);
    }
    @Test
    public void testeQuantityEqualToDiscountAndFreeQuantity() {
        // Given
        Item item = new DiscountItemByGetsFreeOne("banane", 0.5f, 4, 5, 1);
        // When
        Float sum = item.calculateCost();
        // Then
        assertEquals("1 costs 0.5$ && by 4 getting 1 free  then 5 cost 2f$ ", 2f, sum, 0f);
    }


    @Test
    public void testCaseQuantityThanDiscountAndFreeQuantity() {
        // Given
        Item item = new DiscountItemByGetsFreeOne("Pizza", 0.5f, 5, 14, 2);
        // When
        Float sum = item.calculateCost();
        // Then
        assertEquals("1 cost 0.5$ && by 5 getting 2 free then 14 costs 5$ ", 5f, sum, 0f);
    }

    @Test
    public void testCaseQuantityThanDiscountAndFreeQuantity10() {
        // Given
        Item item = new DiscountItemByGetsFreeOne("Pizza", 0.5f, 4, 10, 2);
        // When
        Float sum = item.calculateCost();
        // Then
        assertEquals("1 costs 0.5$ && by 4 getting 1 free then 10 costs 4$ ", 4f, sum, 0f);
    }
}