package one.shirokova.online_shop.bag.dao;

import one.shirokova.online_shop.bag.Bag;

public interface BagDao {
    Bag createBag(Bag bag);

    Bag getBag(long id);

    void removeBag(long id);

    Bag updateBag(Bag bag);
}
