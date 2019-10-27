package supermarket;
import static org.junit.Assert.*;
import org.junit.Test;
import supermarket.domain.Item;
import supermarket.domain.SimpleItem;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class ItemSimpleTest {
    @Test
    public void testOneAndTwoItemWithHerPrice(){
        //Given
        Item item= new SimpleItem("banana", 0.65f, 2);
        //when
        Float sum=item.calculateCost();
        //then
        assertEquals("the one costs $0.65 then two  costs 1.3f", 1.3f, sum,0f);
    }
    @Test
    public void testWithManyProductAndNotMultiple(){
         //Given
        Item item= new SimpleItem("orange",4 ,1f, 3);
        //when
        Float sum=item.calculateCost();
        //then
        assertEquals("the 3 costs 1 dollar then 4 cost 1.34$ ", 1.34f, sum, 0f);

    }
    @Test
    public void testWithManyProduct(){
        //Given
        Item item= new SimpleItem("orange",9 ,1f, 3);
        //when
        Float sum=item.calculateCost();
        //then
        assertEquals("the 3 costs 1 dollar then 9 cost 3$ ", 3f, sum, 0f);

    }
}
