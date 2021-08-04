package one.shirokova.online_shop.repository;

import one.shirokova.online_shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
