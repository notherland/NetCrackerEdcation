package one.shirokova.online_shop.bag;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.shirokova.online_shop.entity.Bag;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class BagDTO extends Bag {
    private Long id = 0l;
    private Map<Long, Integer> items = new HashMap<>();
}
