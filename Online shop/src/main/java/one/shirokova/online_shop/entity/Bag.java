package one.shirokova.online_shop.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "bags")
public class Bag{
    @Id
    @GeneratedValue
    private Long id = 0l;
    private Map<Long, Integer> items = new HashMap<>();
}