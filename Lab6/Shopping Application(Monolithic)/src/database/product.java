package database;

public class product {
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;

    public product(String productId, String productName, String productDescription, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public double productPrice() {
        return this.productPrice;
    }

    @Override
    public String toString() {
        return "ID: " + this.productId + ", Name: " + this.productName + ", Description :" + this.productDescription
                + ", Price: $" + this.productPrice;
    }
}
