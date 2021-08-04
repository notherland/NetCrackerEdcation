package one.shirokova.online_shop.bag;

import org.springframework.http.ResponseEntity;

public interface BagService {
    ResponseEntity<BagDTO> createBag(BagDTO bag);

    ResponseEntity<BagDTO> getBag(long id);

    void removeBag(long id);

    BagDTO updateBag(BagDTO bag);

    void addItemToBag(Long bagId, Long itemId);

    void removeItemFromBag(Long bagId, Long itemId);

}
