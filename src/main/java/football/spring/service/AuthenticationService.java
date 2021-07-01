package football.spring.service;

import football.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
