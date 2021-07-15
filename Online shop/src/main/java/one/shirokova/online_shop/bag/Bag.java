package one.shirokova.online_shop.bag;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Bag {
    private Long id = 0l;
    private Map<Long, Integer> items = new HashMap<>();
}
