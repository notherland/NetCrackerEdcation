package one.shirokova.online_shop.item.dao;

import one.shirokova.online_shop.item.Item;

import java.util.Map;

public interface ItemDao {
    Item createItem(Item item);

    Item getItem(long id);

    void removeItem(long id);

    Item updateItem(Item item);

    Map<Long, Item> getItemList();
}
