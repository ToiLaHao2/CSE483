package service;

import entity.Product;
import entity.User;

public class PaymentServiceImpl implements PaymentService {
    private User user;
    private Product product;

    public PaymentServiceImpl(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    @Override
    public void processPayment() {
        System.out.println("Customer :" + user.getUsername());
        System.out.println("Product :" + product.toString());
    }

}
