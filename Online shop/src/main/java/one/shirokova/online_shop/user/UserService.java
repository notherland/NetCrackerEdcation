package one.shirokova.online_shop.user;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserDTO> createUser(UserDTO user);

    ResponseEntity<UserDTO> getUser(long id);

    void removeUser(long id);

    UserDTO updateUser(UserDTO user);

    UserDTO findByLogin(String login);
}
