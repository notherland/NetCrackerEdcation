package one.shirokova.online_shop.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class Item {
    private Long id;
    private Category category;
    private Color color;

    public Item() {

    }
}

