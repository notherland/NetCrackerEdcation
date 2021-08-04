package one.shirokova.online_shop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.shirokova.online_shop.entity.User;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
public class UserDTO extends User {
    public UserDTO() {}

    @JsonIgnore
    private Long id;

    @JsonProperty(value = "login")
    private String login;

    @JsonProperty(value = "password")
    private String password;

    private long bagId;
}
