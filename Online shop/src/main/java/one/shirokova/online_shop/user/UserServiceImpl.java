package one.shirokova.online_shop.user;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.user.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
@RequestMapping(value = "/user")
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public User createUser(User user) {
        log.trace("Creating user with login" + user.getLogin());

        // Проверка на единственность, проверка пароля

        return userDao.createUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public User getUser(long id) {
        log.trace("Getting user with " + id);

        return userDao.getUser(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
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
