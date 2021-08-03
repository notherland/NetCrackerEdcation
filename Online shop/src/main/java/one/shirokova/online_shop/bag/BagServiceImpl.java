package one.shirokova.online_shop.bag;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.bag.dao.BagDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Bag> createBag(Bag bag) {
        return new ResponseEntity<>(bagDao.createBag(bag), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public ResponseEntity<Bag> getBag(@RequestBody long id) {
        Map<Long, Integer> copy = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : bagDao.getBag(id).getItems().entrySet())
        {
            copy.put(entry.getKey(), entry.getValue());
        }
        return new ResponseEntity(Bag.builder()
                .id(id)
                .items(copy).build(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeBag(@RequestBody long id) {
        bagDao.removeBag(id);
    }

    @Override
    public Bag updateBag(Bag bag) {
        return bagDao.updateBag(bag);
    }

    @Override
    public void addItemToBag(Long bagId, Long itemId) {
        Bag bag = getBag(bagId).getBody();
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
        Bag bag = getBag(bagId).getBody();
        Map list = bag.getItems();

        if (null != list.get(itemId)) {
            list.put(itemId, (Long)list.get(itemId) - 1);
        }

        bagDao.updateBag(bag);
    }
}
