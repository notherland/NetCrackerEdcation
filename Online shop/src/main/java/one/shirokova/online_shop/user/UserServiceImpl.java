package one.shirokova.online_shop.user;

import one.shirokova.online_shop.bag.Bag;
import one.shirokova.online_shop.user.dao.UserDao;
import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService{
    private static final Logger logger = Logger.getLogger("user_service");

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        logger.trace("Creating user with login" + user.getLogin());

        // Проверка на единственность, проверка пароля

        return userDao.createUser(user);
    }

    @Override
    public User getUser(long id) {
        logger.trace("Getting user with " + id);

        return userDao.getUser(id);
    }

    @Override
    public void removeUser(long id) {
        logger.trace("Removing user with " + id);

        userDao.removeUser(id);
    }

    @Override
    public User updateUser(User user) {
        logger.trace("Updating user with id" + user.getId());

        return userDao.updateUser(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }
}
