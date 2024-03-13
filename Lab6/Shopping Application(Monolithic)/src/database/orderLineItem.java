package database;

public class orderLineItem {
    private String orderLineId;
    private String orderLineSkuCode;
    private double product_price;
    private int quantity;

    public orderLineItem(String orderLineId, String orderLineSkuCode, double product_price, int quantity) {
        this.orderLineId = orderLineId;
        this.orderLineSkuCode = orderLineSkuCode;
        this.product_price = product_price;
        this.quantity = quantity;
    }

    public String getOrderLineSkuCode() {
        return this.orderLineSkuCode;
    }

    public double getProduct_Price() {
        return this.product_price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
