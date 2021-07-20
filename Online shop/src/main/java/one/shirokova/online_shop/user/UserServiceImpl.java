package one.shirokova.online_shop.user;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.user.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        log.trace("Creating user with login" + user.getLogin());

        // Проверка на единственность, проверка пароля

        return userDao.createUser(user);
    }

    @Override
    public User getUser(long id) {
        log.trace("Getting user with " + id);

        return userDao.getUser(id);
    }

    @Override
    public void removeUser(long id) {
        log.trace("Removing user with " + id);

        userDao.removeUser(id);
    }

    @Override
    public User updateUser(User user) {
        log.trace("Updating user with id" + user.getId());

        return userDao.updateUser(user);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
