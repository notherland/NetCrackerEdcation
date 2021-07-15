package one.shirokova.online_shop.item.dao;

import one.shirokova.online_shop.bag.Bag;
import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.item.Item;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ItemDaoImpl implements ItemDao{
    private static final Logger logger = Logger.getLogger("item_dao");

    //??? Раскидать по категориям?
    private Map<Long, Item> items = new HashMap<>();

    private final IdGenerator idGenerator;

    public ItemDaoImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Item createItem(Item item) {
        long id = idGenerator.getId();

        //????
        Item toStore = Item.builder()
                .id(id)
                .color(item.getColor())
                .category(item.getCategory()).build();

        items.put(toStore.getId(), toStore);

        item.setId(id);

        return item;
    }

    @Override
    public Item getItem(long id) {
        logger.trace("Getting item with " + id);

        Item stored = items.get(id);

        //???????
        return Item.builder()
                .id(id)
                .color(stored.getColor())
                .category(stored.getCategory()).build();
    }

    @Override
    public void removeItem(long id) {
        logger.trace("Removing item with " + id);

        items.remove(id);
    }

    @Override
    public Item updateItem(Item item) {
        Item initialItem = items.get(item.getId());

        logger.trace("Updating Item with id " + item.getId());

        if (initialItem == null){
            logger.warn("Updating item with id " + initialItem.getId() + " failed: item does not exist");
            throw new RuntimeException("There is no item with id" + item.getId());
        }

        initialItem.setCategory(initialItem.getCategory());
        initialItem.setColor(initialItem.getColor());

        logger.trace("Updated bag with id " + item.getId());

        return item;
    }
}
