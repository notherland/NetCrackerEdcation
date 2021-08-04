package one.shirokova.online_shop.bag;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.entity.Bag;
import one.shirokova.online_shop.repository.BagRepository;
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

    private final BagRepository bagRepository;

    public BagServiceImpl(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<BagDTO> createBag(BagDTO bag) {
        return new ResponseEntity<>(bagRepository.save(bag), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public ResponseEntity<BagDTO> getBag(@RequestBody long id) {
        Bag bag = bagRepository.findById(id).get();
        return new ResponseEntity(BagDTO.builder()
                .id(bag.getId()).build(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeBag(@RequestBody long id) {
        bagRepository.deleteById(id);
    }

    @Override
    public BagDTO updateBag(BagDTO bag) {
        return null;
    }

    @Override
    public void addItemToBag(Long bagId, Long itemId) {
    }

    @Override
    public void removeItemFromBag(Long bagId, Long itemId) {
    }
}
