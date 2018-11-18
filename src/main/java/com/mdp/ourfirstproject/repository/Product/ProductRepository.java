package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;
import com.mdp.ourfirstproject.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    boolean create(Product product);
    Product readByID(long id) throws NoSuchProductException;
    void update(Product product);
    void delete(long id);
    List<Product> readByName(String productName);
    List<Product> readAll();
    List<Product> readByKeywordInDescription(String keyword);
    void cleanUp();



}
