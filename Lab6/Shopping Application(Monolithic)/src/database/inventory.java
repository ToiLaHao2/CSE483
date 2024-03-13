package database;

public class inventory {
    private String invId;
    private String productId;
    private int quantity;

    public inventory(String invId, String productId, int quantity) {
        this.invId = invId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
