import service.OrderServiceImpl;
import service.PaymentServiceImpl;
import service.UserServiceImpl;

public class ServiceForwarder {
    private UserServiceImpl userServiceImpl;
    private OrderServiceImpl orderServiceImpl;
    private PaymentServiceImpl paymentServiceImpl;

    public ServiceForwarder(UserServiceImpl userServiceImpl, OrderServiceImpl orderServiceImpl,
            PaymentServiceImpl paymentServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
        this.paymentServiceImpl = paymentServiceImpl;
    }

    public void checkInfomation(String username, String password) {
        this.userServiceImpl.authenticateUser(username, password);
    }
}
