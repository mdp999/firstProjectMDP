package com.mdp.ourfirstproject.repository;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;

import java.util.List;

public interface IProductRepository {

    void create(Product product);
    Product readByID(long id) throws NoSuchProductException;
    void update(Product product);
    void delete(long id);
    List<Product> readByName(String productName);
    List<Product> readAll();
    List<Product> readByKeywordInDescription(String keyword);
    void cleanUp();



}
