package football.spring.service;

import football.spring.model.Order;
import football.spring.model.ShoppingCart;
import football.spring.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
