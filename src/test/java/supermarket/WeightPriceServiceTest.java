package supermarket;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import supermarket.domain.WeightPrice;
import supermarket.domain.WeightUnit;
import supermarket.service.WeightPriceService;

import java.math.BigDecimal;

public class WeightPriceServiceTest  {
    private WeightPrice weightPrice;
    private BigDecimal price;
    private BigDecimal quantity;
    @Before
    public void setUp() throws Exception {
        weightPrice = new WeightPrice(new BigDecimal(1.99f), WeightUnit.POUND);
         price =new BigDecimal(1.0f);
         quantity=new BigDecimal(3f);
    }

    @Test
    public void getSinglePrice() throws Exception {
        BigDecimal value=WeightPriceService.getSinglePrice(weightPrice, new BigDecimal(4), WeightUnit.OUNCE);
        BigDecimal valueSingle=WeightPriceService.getSinglePrice(weightPrice, new BigDecimal(1.0f), WeightUnit.OUNCE);
        Assert.assertEquals("$1.99/pound (so what does 4 ounces cost?)", new BigDecimal(0.50), value);
        Assert.assertEquals("$1.99/pound (so what does 1 ounces cost?)", new BigDecimal("0.13"), valueSingle);
    }


    @Test
        public void getDiscountPrice() throws Exception {
        BigDecimal values=WeightPriceService.getDiscountPrice(new WeightPrice(new BigDecimal(1), WeightUnit.POUND), new BigDecimal(32f), WeightUnit.OUNCE, price,quantity);

        Assert.assertEquals("32 Ounce costs 2 Dollars: 32 Ounce equals 2 Pounds, each costs 1 Dollar (No discount selected)", new BigDecimal(2), values);

    }
    @Test
    public void getDiscountPrice48() throws Exception {
        BigDecimal values=WeightPriceService.getDiscountPrice(new WeightPrice(new BigDecimal(1f), WeightUnit.POUND), new BigDecimal(48f), WeightUnit.OUNCE, price,quantity);
        Assert.assertEquals("48 Ounce costs 1 Dollar: 48 Ounce equals 3 Pounds, the threeForOne discount selected", new BigDecimal(1f),values );


    }
}