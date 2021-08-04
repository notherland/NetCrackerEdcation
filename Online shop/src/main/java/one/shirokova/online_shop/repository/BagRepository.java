package one.shirokova.online_shop.repository;

import one.shirokova.online_shop.entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<Bag, Long> {
}
