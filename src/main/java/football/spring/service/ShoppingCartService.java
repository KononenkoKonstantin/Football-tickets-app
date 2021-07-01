package football.spring.service;

import football.spring.model.GameSession;
import football.spring.model.ShoppingCart;
import football.spring.model.User;

public interface ShoppingCartService {
    void addSession(GameSession gameSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
