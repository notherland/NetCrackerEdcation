package one.shirokova.online_shop.item.dao;

import one.shirokova.online_shop.item.Item;

public interface ItemDao {
    Item createItem(Item item);

    Item getItem(long id);

    void removeItem(long id);

    Item updateItem(Item item);
}
