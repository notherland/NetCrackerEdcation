package one.shirokova.online_shop.item;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Item {
    private String id;
    private Category category;
    private Color color;
}

