package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.model.ProductCategory;

import java.util.List;

public interface IProductRepository {

    boolean save(Product transfer) throws ProductException;
    boolean deleteById(long id) throws ProductException;
    boolean update(Product transfer) throws ProductException;
    Product findById(long id) throws ProductException;
    Product findByName(String productName);
    List<Product> findByProductCategory(ProductCategory productCategory);
    List<Product> findByProducer(String producerName);
    List<Product> findAll();
    void cleanUp();

}