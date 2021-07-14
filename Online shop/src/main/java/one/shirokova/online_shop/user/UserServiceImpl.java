package one.shirokova.online_shop.user;

import one.shirokova.online_shop.bag.Bag;
import one.shirokova.online_shop.item.Item;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public User createUser(String login) {
        User newUser = new User();

        newUser.setLogin(login);
        newUser.setBag(new Bag());

        return newUser;
    }

    @Override
    public void addItem(User user, String id) {
        user.getBag().addItem(id);
    }

    @Override
    public boolean removeItem(User user, String id) {
        return user.getBag().removeItem(id);
    }
}
