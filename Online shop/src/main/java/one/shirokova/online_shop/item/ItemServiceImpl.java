package one.shirokova.online_shop.item;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.entity.Item;
import one.shirokova.online_shop.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Service
@RestController
@RequestMapping(value="/item")
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO item) {
        //Проверки
        return new ResponseEntity<>(itemRepository.save(item), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/?id=<id>")
    @Override
    public ResponseEntity<ItemDTO> getItem(@RequestBody long id) {
        Item item = itemRepository.findById(id).get();
        return new ResponseEntity<>(ItemDTO.builder()
                .id(item.getId())
                .category(item.getCategory())
                .color(item.getColor()).build(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/?id=<id>")
    @Override
    public void removeItem(@RequestBody long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO updateItem(ItemDTO item) {
        return null;
    }
}
