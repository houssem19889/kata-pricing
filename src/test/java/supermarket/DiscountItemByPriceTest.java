package supermarket;

import static org.junit.Assert.*;
import org.junit.Test;
import supermarket.domain.ItemDiscount;
import supermarket.service.DiscountItemService;
import supermarket.service.IDiscountItemService;

import java.math.BigDecimal;
import java.text.ParseException;

public class DiscountItemByPriceTest  {
    private IDiscountItemService iDiscountItemService =new DiscountItemService();
    private BigDecimal free = BigDecimal.ZERO;
    @Test
    public void testCaseQuantityMultipleOfPromotionalQuantity() throws ParseException {
        // Given
        ItemDiscount product = new ItemDiscount("chapati", new BigDecimal(0.5), new BigDecimal(3), new BigDecimal(6), free,new BigDecimal(1));
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByPrice(product);
        // Then
        assertEquals("3 costs 1$ and 1 costs 0.5$ then 6 costs 2 ", new BigDecimal(2), sum);
    }
    @Test
    public void testCaseQuantityNotMultipleOfPromotionalQuantity() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Pizza", new BigDecimal(0.5f), new BigDecimal(3), new BigDecimal(4),free ,new BigDecimal(1f));
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByPrice(item);
        // Then
        assertEquals("3 costs 1$ && 1  costs 0.5$  then 4 costs 1.5$ ", new BigDecimal(1.5f), sum);
    }


    @Test
    public void testCaseQuantityOfPromotionalQuantity() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Pizza", new BigDecimal(0.65f), new BigDecimal(3), new BigDecimal(4),free ,new BigDecimal(1f));
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByPrice(item);
        // Then
        assertEquals("3 costs 1$ && 1  costs 0.65$  then 4 costs 1.65$ ", new BigDecimal(1.65f), sum);
    }



    @Test
    public void testCaseQuantityOfPromotionalQuantity2() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Pizza", new BigDecimal(0.5f), new BigDecimal(3), new BigDecimal(4),free ,new BigDecimal(1f));
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByPrice(item);
        // Then
        assertEquals("3 costs 1$ && 1  costs 0.5$  then 4 costs 1.5$ ", new BigDecimal(1.5f), sum);
    }
}