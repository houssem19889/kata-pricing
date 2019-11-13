package supermarket;

import org.junit.Test;
import supermarket.domain.ItemDiscount;
import supermarket.service.DiscountItemService;
import supermarket.service.IDiscountItemService;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.text.ParseException;


public class DiscountItemByGetsFreeOneTest  {
    private IDiscountItemService iDiscountItemService =new DiscountItemService();
    private BigDecimal free = BigDecimal.ZERO;
    @Test
    public void testDiscountWithQuantity() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Chocolat", new BigDecimal(1), new BigDecimal(5),new BigDecimal(3) ,new BigDecimal(2),free);
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByGetsFreeOne(item);
        // Then
        assertEquals("1 costs 1$ && by 5 getting 2 free then 3 for 3$ ", new BigDecimal("3"), sum);
    }
    @Test
    public void testeQuantityEqualToDiscountAndFreeQuantity() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("banane", new BigDecimal(0.5), new BigDecimal(4),new BigDecimal(5), new BigDecimal(1),free);
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByGetsFreeOne(item);
        // Then
        assertEquals("1 costs 0.5$ && by 4 getting 1 free  then 5 cost 2f$ ", new BigDecimal("2.0"), sum);
    }


    @Test
    public void testCaseQuantityThanDiscountAndFreeQuantity() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Pizza", new BigDecimal(0.5), new BigDecimal(5), new BigDecimal(14), new BigDecimal(2),free);
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByGetsFreeOne(item);
        // Then
        assertEquals("1 cost 0.5$ && by 5 getting 2 free then 14 costs 5$ ", new BigDecimal("5.0"), sum);
    }

    @Test
    public void testCaseQuantityThanDiscountAndFreeQuantity10() throws ParseException {
        // Given
        ItemDiscount item = new ItemDiscount("Pizza", new BigDecimal(0.5), new BigDecimal(4), new BigDecimal(10), new BigDecimal(2),free);
        // When
        BigDecimal sum = iDiscountItemService.calculateCostByGetsFreeOne(item);
        // Then
        assertEquals("1 costs 0.5$ && by 4 getting 1 free then 10 costs 4$ ", new BigDecimal("4.0"), sum);
    }





}