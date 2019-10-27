package supermarket;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import supermarket.domain.WeightPrice;
import supermarket.domain.WeightUnit;
import supermarket.service.WeightPriceService;

public class WeightPriceServiceTest  {
    private WeightPrice weightPrice;
    private Float price;
    private Float quantity;
    @Before
    public void setUp() throws Exception {
        weightPrice = new WeightPrice(1.99f, WeightUnit.POUND);
         price =1.0f;
         quantity=3f;
    }
    @Test
    public void getSinglePrice() throws Exception {
        Float value=WeightPriceService.getSinglePrice(weightPrice, 4.0f, WeightUnit.OUNCE);
        Float valueSingle=WeightPriceService.getSinglePrice(weightPrice, 1.0f, WeightUnit.OUNCE);
        Assert.assertEquals("$1.99/pound (so what does 4 ounces cost?)", 0.5f, value, 0f);
        Assert.assertEquals("$1.99/pound (so what does 1 ounces cost?)", 0.13f, valueSingle, 0f);
    }


    @Test
        public void getDiscountPrice() throws Exception {


        Float values=WeightPriceService.getDiscountPrice(new WeightPrice(1f, WeightUnit.POUND), 32f, WeightUnit.OUNCE, price,quantity);

        Assert.assertEquals("32 Ounce costs 2 Dollars: 32 Ounce equals 2 Pounds, each costs 1 Dollar (No discount selected)", 2f, values, 0f);




    }
    @Test
    public void getDiscountPrice48() throws Exception {
        Float values=WeightPriceService.getDiscountPrice(new WeightPrice(1f, WeightUnit.POUND), 48f, WeightUnit.OUNCE, price,quantity);
        Assert.assertEquals("48 Ounce costs 1 Dollar: 48 Ounce equals 3 Pounds, the threeForOne discount selected", 1f,values , 0f);


    }
}