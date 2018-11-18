package com.mdp.ourfirstproject.repository;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;

import java.util.List;

public class ProductRepository implements IProductRepository{


    @Override
    public void create(Product product) {

    }

    @Override
    public Product readByID(long id) throws NoSuchProductException {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Product> readByName(String productName) {
        return null;
    }

    @Override
    public List<Product> readAll() {
        return null;
    }

    @Override
    public List<Product> readByKeywordInDescription(String keyword) {
        return null;
    }

    @Override
    public void cleanUp() {

    }
}
