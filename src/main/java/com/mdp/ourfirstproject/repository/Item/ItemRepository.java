package com.mdp.ourfirstproject.repository.Item;

import com.mdp.ourfirstproject.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
