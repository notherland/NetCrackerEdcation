package one.shirokova.online_shop.bag;

import org.springframework.http.ResponseEntity;

public interface BagService {
    ResponseEntity<Bag> createBag(Bag bag);

    ResponseEntity<Bag> getBag(long id);

    void removeBag(long id);

    Bag updateBag(Bag bag);

    void addItemToBag(Long bagId, Long itemId);

    void removeItemFromBag(Long bagId, Long itemId);

}
