package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;

import java.util.List;

public interface IProductRepository {

    boolean save(Product transfer) throws ProductException;
    boolean deleteById(long id) throws ProductException;
    boolean update(Product transfer) throws ProductException;
    Product findById(long id) throws ProductException;
    List<Product> readByKeywordInDescription(String keyword);
    List<Product> findByName(String productName);
    List<Product> findAll();
    void cleanUp();

}