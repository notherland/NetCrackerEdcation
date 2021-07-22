package one.shirokova.online_shop.item;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.item.dao.ItemDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Service
@RestController
@RequestMapping(value="/item")
public class ItemServiceImpl implements ItemService{

    private final ItemDao itemDao;

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public Item createItem(Item item) {
        //Проверки
        return itemDao.createItem(item);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public Item getItem(long id) {
        return itemDao.getItem(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeItem(long id) {
        itemDao.removeItem(id);
    }

    @Override
    public Item updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public Map<Long, Item> getItemList() {
        return itemDao.getItemList();
    }


    @Override
    public Map<String, Item> getCategoryList(String category) {
        return null;
    }
}
