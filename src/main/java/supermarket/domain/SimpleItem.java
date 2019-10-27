package supermarket.domain;

import supermarket.util.Util;

/**
 * Created by houssem89 on 27/10/2019.
 */
public class SimpleItem implements Item {

    private String name;

    private Float price;

    private Integer quantity;

    public SimpleItem(String name, Integer quantity, Float price, Integer number) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.number = number;
    }

    public SimpleItem(String name, Float price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    private Integer number;

    @Override
    public Float calculateCost() {
        Float result=0f;
        if(number!=null){
         result  = (this.quantity * (this.price / this.number));
        }else {
            result  = this.quantity * this.price ;
        }

        return Util.formateCost(result);
    }
}
