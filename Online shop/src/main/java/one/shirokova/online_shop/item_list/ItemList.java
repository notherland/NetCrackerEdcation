package one.shirokova.online_shop.item_list;

import lombok.Data;
import one.shirokova.online_shop.item.Category;
import one.shirokova.online_shop.item.Item;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


@Data
public class ItemList {
    private Map<String, Item> shirtsList = new HashMap<>();
    private Map<String, Item> trousersList = new HashMap<>();
    private Map<String, Item> skirtsList = new HashMap<>();
    private Map<String, Item> sweatersList = new HashMap<>();

    Logger logger = Logger.getLogger("item_list");

    public void addItem(Item item){
        Category category = item.getCategory();

        logger.trace("ADDING " + category + " " + item.getId());

        switch(category){
            case SHIRT: {
                shirtsList.put(item.getId(), item);
                break;
            }
            case TROUSERS: {
                trousersList.put(item.getId(), item);
                break;
            }
            case SKIRT: {
                skirtsList.put(item.getId(), item);
                break;
            }
            case SWEATER: {
                sweatersList.put(item.getId(), item);
                break;
            }
        }

        logger.trace("ADDED " + category + " " + item.getId());
    }
}
