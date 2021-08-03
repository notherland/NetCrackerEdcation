package one.shirokova.online_shop.user;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> getUser(long id);

    void removeUser(long id);

    User updateUser(User user);

    User findByLogin(String login);
}
