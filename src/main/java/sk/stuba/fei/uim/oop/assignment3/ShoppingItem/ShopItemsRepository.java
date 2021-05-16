package sk.stuba.fei.uim.oop.assignment3.ShoppingItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopItemsRepository extends CrudRepository<ShoppingItem, Long> {
    Optional<ShoppingItem> findById(Long id);
}
