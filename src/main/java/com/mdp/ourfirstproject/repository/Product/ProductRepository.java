package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findByName(String productName);
    List<Product> findBytax(BigDecimal productTax);
    List<Product> findByDescriptionContaining(String productDescription);
    List<Product> findByAmount(BigDecimal productAmount);
    List<Product> findByCategory(ProductCategory productCategory);

    List<Product> findAll();
}
