package one.shirokova.online_shop.user;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.entity.User;
import one.shirokova.online_shop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@Service
@RestController
@RequestMapping(value = "/user")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        log.trace("Creating user with login" + user.getLogin());

        // Проверка на единственность, проверка пароля

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public ResponseEntity<UserDTO> getUser(@RequestBody long id) {
        log.trace("Getting user with " + id);

        User user = userRepository.findById(id).get();

        return new ResponseEntity<>(UserDTO.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .bagId(user.getBagId()).build(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeUser(@RequestBody long id) {
        log.trace("Removing user with " + id);

        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        log.trace("Updating user with id" + user.getId());

        return null;
    }

    @Override
    public UserDTO findByLogin(String login) {
        User user = userRepository.findByLogin(login).get();
        return UserDTO.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .bagId(user.getBagId()).build();
    }
}
