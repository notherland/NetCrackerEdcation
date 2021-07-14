package one.shirokova.online_shop.user;

import lombok.Data;
import one.shirokova.online_shop.bag.Bag;

@Data
public class User {
    private String login;
    private Bag bag;
}
