package one.shirokova.online_shop.item;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ItemService {
    ResponseEntity<ItemDTO> createItem(ItemDTO item);

    ResponseEntity<ItemDTO> getItem(long id);

    void removeItem(long id);

    ItemDTO updateItem(ItemDTO item);
}
