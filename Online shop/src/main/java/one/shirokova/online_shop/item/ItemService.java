package one.shirokova.online_shop.item;

import one.shirokova.online_shop.item.dao.ItemDao;

import java.util.Map;

public interface ItemService {
    Item createItem(Item item);

    Item getItem(long id);

    void removeItem(long id);

    Item updateItem(Item bag);


    Map<String, Item> getCategoryList(String category, ItemDao itemList);
}
