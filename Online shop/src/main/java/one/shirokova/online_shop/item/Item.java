package one.shirokova.online_shop.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class Item {
    @JsonIgnore
    private Long id;
    @JsonProperty(value = "category")
    private Category category;
    @JsonProperty(value = "color")
    private Color color;

    public Item() {

    }
}

