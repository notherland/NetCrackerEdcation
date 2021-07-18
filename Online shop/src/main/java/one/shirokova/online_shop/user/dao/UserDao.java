package one.shirokova.online_shop.user.dao;

import one.shirokova.online_shop.user.User;

public interface UserDao {

    User createUser(User user);

    User getUser(long id);

    void removeUser(long id);

    User updateUser(User user);

    User findByLogin(String login);
}
