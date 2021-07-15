package one.shirokova.online_shop.item;

import one.shirokova.online_shop.item.dao.ItemDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{
    private static final Logger logger = Logger.getLogger("item_service");

    private final ItemDao itemDao;

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }


    @Override
    public Item createItem(Item item) {
        //Проверки
        return itemDao.createItem(item);
    }

    @Override
    public Item getItem(long id) {
        return itemDao.getItem(id);
    }

    @Override
    public void removeItem(long id) {
        itemDao.removeItem(id);
    }

    @Override
    public Item updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public Map<String, Item> getCategoryList(String category, ItemDao itemList) {
        return null;
    }
}
