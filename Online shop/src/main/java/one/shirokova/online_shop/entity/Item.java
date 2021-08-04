package one.shirokova.online_shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import one.shirokova.online_shop.item.Category;
import one.shirokova.online_shop.item.Color;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items", schema = "Online_shop")
public class Item {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "category")
    private Category category;

    @Column(name = "color")
    private Color color;

    public Item() {

    }
}
