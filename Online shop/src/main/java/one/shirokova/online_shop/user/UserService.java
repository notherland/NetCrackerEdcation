package one.shirokova.online_shop.user;

import one.shirokova.online_shop.item.Item;

import java.util.List;

public interface UserService {
    public User createUser(String login);
    public void addItem(User user, String id);
    public boolean removeItem(User user, String id);
}
