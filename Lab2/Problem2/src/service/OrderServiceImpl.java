package service;

public class OrderServiceImpl implements OrderService {

    @Override
    public void placeOrder(int userId, String productName) {
        System.out.println("User " + userId + " created an order for Product " + productName);

    }
}
