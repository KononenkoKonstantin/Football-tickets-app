package football.spring.dao;

import football.spring.model.Order;
import football.spring.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
