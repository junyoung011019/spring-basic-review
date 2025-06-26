package spring.basic.review.order;

public interface OrderService {

    Order orderProduct(Long id, String productName, Integer productPrice);

}
