package database;

import java.util.ArrayList;
import java.util.List;

public class order {
    private String orderId;
    private String orderNumber;
    private List<orderLineItem> lineItems;

    public order(String orderId, String orderNumber, ArrayList<orderLineItem> lineItems) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.lineItems = lineItems;
    }

    public String getOrderNumber(){
        return this.orderNumber;
    }
}
