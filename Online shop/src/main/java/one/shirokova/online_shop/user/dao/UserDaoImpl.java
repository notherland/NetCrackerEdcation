package one.shirokova.online_shop.user.dao;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.user.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class UserDaoImpl implements UserDao{

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
        log.trace("Getting user with " + id);
        User stored = users.get(id);
        return User.builder()
                .id(stored.getId())
                .login(stored.getLogin())
                .password(stored.getPassword())
                .bagId(stored.getBagId()).build();
    }

    @Override
    public void removeUser(long id) {
        log.trace("Removing user with " + id);

        users.remove(id);
    }

    @Override
    public User updateUser(User user) {
        User initialUser = users.get(user.getId());

        log.trace("Updating user with id " + user.getId());

        if (initialUser == null){
            log.warn("Updating user with id " + initialUser.getId() + " failed: user does not exist");
            throw new RuntimeException("There is no user with id" + user.getId());
        }

        initialUser.setLogin(user.getLogin());
        initialUser.setPassword(user.getPassword());
        initialUser.setBagId(user.getBagId());

        log.trace("Updated user with id " + user.getId());

        return user;
    }

    @Override
    public User findByLogin(String login) {
        for (User user:users.values()){
            if (login.equals(user.getLogin()))
                return getUser(user.getId());
        }

        return null;
    }
}
