package one.shirokova.online_shop.user;

import one.shirokova.online_shop.item.Item;

import java.util.List;
import java.util.Map;

public interface UserService {
    User createUser(User user);

    User getUser(long id);

    void removeUser(long id);

    User updateUser(User user);

    User findByLogin(String login);
}
