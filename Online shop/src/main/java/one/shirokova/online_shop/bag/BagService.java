package one.shirokova.online_shop.bag;

import one.shirokova.online_shop.item.*;

import java.util.List;

public interface BagService {
    Bag createBag(Bag bag);

    Bag getBag(long id);

    void removeBag(long id);

    Bag updateBag(Bag bag);
}
