package one.shirokova.online_shop.item.dao;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.item.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ItemDaoImpl implements ItemDao{

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
        log.trace("Getting item with " + id);

        Item stored = items.get(id);

        //???????
        return Item.builder()
                .id(id)
                .color(stored.getColor())
                .category(stored.getCategory()).build();
    }

    @Override
    public void removeItem(long id) {
        log.trace("Removing item with " + id);

        items.remove(id);
    }

    @Override
    public Item updateItem(Item item) {
        Item initialItem = items.get(item.getId());

        log.trace("Updating Item with id " + item.getId());

        if (initialItem == null){
            log.warn("Updating item with id " + initialItem.getId() + " failed: item does not exist");
            throw new RuntimeException("There is no item with id" + item.getId());
        }

        initialItem.setCategory(initialItem.getCategory());
        initialItem.setColor(initialItem.getColor());

        log.trace("Updated bag with id " + item.getId());

        return item;
    }

    @Override
    public Map<Long, Item> getItemList() {
        Map<Long, Item> copy = new HashMap<>();
        for (Map.Entry<Long, Item> entry : items.entrySet())
        {
            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }
}
