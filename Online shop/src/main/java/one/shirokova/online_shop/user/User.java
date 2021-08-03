package one.shirokova.online_shop.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class User {
    public User() {}

    @JsonIgnore
    private Long id;
    @JsonProperty(value = "login")
    private String login;
    @JsonProperty(value = "password")
    private String password;
    private Long bagId;
}
