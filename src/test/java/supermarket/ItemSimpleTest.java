package supermarket;
import static org.junit.Assert.*;
import org.junit.Test;
import supermaket.domain.Item;
import supermaket.domain.SimpleItem;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class ItemSimpleTest {
    @Test
    public void testOneAndTwoItemWithHerPrice(){
        Item item= new SimpleItem("banana", 0.65f, 2);
        Float sum=item.calculateCost();
        assertEquals("the one costs $0.65 then two  costs 1.3f", 1.3f, sum,0f);
    }
    @Test
    public void testWithManyProduct(){
        Item item= new SimpleItem("orange",9 ,1f, 3);
        Float sum=item.calculateCost();
        System.out.print("su"+sum);
        assertEquals("the 3 costs 1 dollar then 9 cost 3$ ", 3f, sum, 0f);

    }
}
