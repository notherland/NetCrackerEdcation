package one.shirokova.online_shop.item_list;

import one.shirokova.online_shop.item.Item;
import org.apache.log4j.Logger;

import java.util.Map;

public class ItemListServiceImpl implements ItemListService{
    Logger logger = Logger.getLogger("item_list_service_impl");
    @Override
    public Map<String, Item> getCategoryList(String category, ItemList itemList) {
        logger.trace("CHECK " + category + " CATEGORY");

        switch(category){
            case "Shirt": {
                return itemList.getShirtsList();
            }
            case "Trousers": {
                return itemList.getTrousersList();
            }
            case "Skirt": {
                return itemList.getSkirtsList();
            }
            case "Sweater": {
                return itemList.getSweatersList();
            }
            default: {
                logger.trace("NO " + category + "CATEGORY");
                return null;
            }
        }
    }
}
