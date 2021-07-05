package football.dao;

import football.model.User;
import football.model.Order;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
