package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {


}
