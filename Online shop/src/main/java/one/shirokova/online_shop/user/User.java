package one.shirokova.online_shop.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User {
    private Long id;
    private String login;
    private String password;
    private Long bagId;
}
