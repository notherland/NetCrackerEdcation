package one.shirokova.online_shop.item_list;

import one.shirokova.online_shop.item.Item;

import java.util.List;
import java.util.Map;

public interface ItemListService {
    public Map<String, Item> getCategoryList(String category, ItemList itemList);
}
