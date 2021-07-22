package one.shirokova.online_shop.bag;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.bag.dao.BagDao;
import one.shirokova.online_shop.item.Item;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RestController
@RequestMapping(value = "/bag")
public class BagServiceImpl implements BagService{

    private final BagDao bagDao;

    public BagServiceImpl(BagDao bagDao) {
        this.bagDao = bagDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public Bag createBag(Bag bag) {
        return bagDao.createBag(bag);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public Bag getBag(long id) {
        Map<Long, Integer> copy = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : bagDao.getBag(id).getItems().entrySet())
        {
            copy.put(entry.getKey(), entry.getValue());
        }
        return Bag.builder()
                .id(id)
                .items(copy).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeBag(long id) {
        bagDao.removeBag(id);
    }

    @Override
    public Bag updateBag(Bag bag) {
        return bagDao.updateBag(bag);
    }

    @Override
    public void addItemToBag(Long bagId, Long itemId) {
        Bag bag = getBag(bagId);
        Map list = bag.getItems();

        if (null == list.get(itemId)) {
            list.put(itemId, 1);
        } else{
            list.put(itemId, (Long)list.get(itemId) + 1);
        }

        bagDao.updateBag(bag);
    }

    @Override
    public void removeItemFromBag(Long bagId, Long itemId) {
        Bag bag = getBag(bagId);
        Map list = bag.getItems();

        if (null != list.get(itemId)) {
            list.put(itemId, (Long)list.get(itemId) - 1);
        }

        bagDao.updateBag(bag);
    }
}
