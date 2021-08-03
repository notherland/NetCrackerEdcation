package one.shirokova.online_shop.item;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ItemService {
    ResponseEntity<Item> createItem(Item item);

    ResponseEntity<Item> getItem(long id);

    void removeItem(long id);

    Item updateItem(Item item);

    Map<Long, Item> getItemList();

    Map<String, Item> getCategoryList(String category);
}
