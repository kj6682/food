package org.kj6682.food;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by luigi on 19/04/16.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByCategory(Item.Category category);

}
