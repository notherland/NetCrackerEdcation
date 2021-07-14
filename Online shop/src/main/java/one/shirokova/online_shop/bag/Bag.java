package one.shirokova.online_shop.bag;

import lombok.Data;
import one.shirokova.online_shop.item.Item;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class Bag {
    private Map<String, Integer> list = new HashMap<>();

    public void addItem(String id){
        if(list.containsKey(id)){
            list.put(id, list.get(id) + 1);
        } else{
            list.put(id, 1);
        }
    }

    public boolean removeItem(String id){

        if (list.containsKey(id)){
            int count = list.get(id);

            if (count > 0) {
                list.put(id, list.get(id) - 1);
            } else{
                list.remove(id);
            }

            return true;
        }

        return false;
    }
}
