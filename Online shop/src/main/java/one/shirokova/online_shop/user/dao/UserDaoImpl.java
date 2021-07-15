package one.shirokova.online_shop.user.dao;

import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.user.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao{
    private static final Logger logger = Logger.getLogger("user_dao");

    private Map<Long, User> users = new HashMap<>();

    private final IdGenerator idGenerator;

    public UserDaoImpl(IdGenerator idGenerator){
        this.idGenerator = idGenerator;
    }


    @Override
    public User createUser(User user) {
        long id = idGenerator.getId();

        User toStore = User.builder()
                .id(id)
                .login(user.getLogin())
                .password(user.getPassword())
                .bagId(user.getBagId()).build();

        users.put(toStore.getId(), toStore);

        user.setId(id);

        return user;
    }

    @Override
    public User getUser(long id) {
        logger.trace("Getting user with " + id);
        User stored = users.get(id);
        return User.builder()
                .id(stored.getId())
                .login(stored.getLogin())
                .password(stored.getPassword())
                .bagId(stored.getBagId()).build();
    }

    @Override
    public void removeUser(long id) {
        logger.trace("Removing user with " + id);

        users.remove(id);
    }

    @Override
    public User updateUser(User user) {
        User initialUser = users.get(user.getId());

        logger.trace("Updating user with id " + user.getId());

        if (initialUser == null){
            logger.warn("Updating user with id " + initialUser.getId() + " failed: user does not exist");
            throw new RuntimeException("There is no user with id" + user.getId());
        }

        initialUser.setLogin(user.getLogin());
        initialUser.setPassword(user.getPassword());
        initialUser.setBagId(user.getBagId());

        logger.trace("Updated user with id " + user.getId());

        return user;
    }
}
