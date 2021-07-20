package one.shirokova.online_shop.bag.dao;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.bag.Bag;
import one.shirokova.online_shop.id_generator.IdGenerator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class BagDaoImpl implements BagDao{

    private Map<Long, Bag> bags = new HashMap<>();

    private final IdGenerator idGenerator;

    public BagDaoImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }


    @Override
    public Bag createBag(Bag bag) {
        long id = idGenerator.getId();

        //????
        Bag toStore = Bag.builder()
                .id(id)
                .items(bag.getItems()).build();

        bags.put(toStore.getId(), toStore);

        bag.setId(id);

        return bag;
    }

    @Override
    public Bag getBag(long id) {
        log.trace("Getting bag with " + id);
        Bag stored = bags.get(id);

        //???????
        return Bag.builder()
                .id(stored.getId())
                .items(stored.getItems()).build();
    }

    @Override
    public void removeBag(long id) {
        log.trace("Removing bag with " + id);

        bags.remove(id);
    }

    @Override
    public Bag updateBag(Bag bag) {
        Bag initialBag = bags.get(bag.getId());

        log.trace("Updating bag with id " + bag.getId());

        if (initialBag == null){
            log.warn("Updating bag with id " + initialBag.getId() + " failed: bag does not exist");
            throw new RuntimeException("There is no bag with id" + bag.getId());
        }

        initialBag.setItems(bag.getItems());

        log.trace("Updated bag with id " + bag.getId());

        return bag;
    }
}
