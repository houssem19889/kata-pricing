package supermarket;
import static org.junit.Assert.*;
import org.junit.Test;
import supermarket.domain.ItemDiscount;
import supermarket.service.DiscountItemService;
import supermarket.service.IDiscountItemService;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class ItemSimpleTest {
    private IDiscountItemService iDiscountItemService =new DiscountItemService();
    @Test
    public void testOneAndTwoItemWithHerPrice() throws ParseException {
        //Given
        ItemDiscount itemDiscount=new ItemDiscount("banana",new BigDecimal(0.65),new BigDecimal(2));
        //when
        BigDecimal sum=iDiscountItemService.calculateCostItem(itemDiscount);
        //then
        assertEquals("the one costs $0.65 then two  costs 1.30", new BigDecimal("1.30"), sum);
    }

    @Test
    public void testWithManyProductAndNotPromotion() throws ParseException {
         //Given
        ItemDiscount item= new ItemDiscount("orange", new BigDecimal(4) ,new BigDecimal(1), 3);
        //when
        BigDecimal sum=iDiscountItemService.calculateCostItem(item);
        //then
        assertEquals("the 3 costs 1 dollar(one for 0.34) then 4 cost 1.34$ ", new BigDecimal("1.34"), sum);

    }

    @Test
    public void testWithManyProduct() throws ParseException {
        //Given
        ItemDiscount item= new ItemDiscount("orange",new BigDecimal(9) ,new BigDecimal(1f), 3);
        //when
        BigDecimal sum=iDiscountItemService.calculateCostItem(item);
        //then
        assertEquals("the 3 costs 1 dollar then 9 cost 3$ ", new BigDecimal(3f), sum);

    }

}
