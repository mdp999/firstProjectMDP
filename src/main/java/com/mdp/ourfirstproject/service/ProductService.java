package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.ItemCategory;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.Product.IProductRepository;
import com.mdp.ourfirstproject.repository.Product.ProductException;
import com.mdp.ourfirstproject.repository.Product.ProductRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private IProductRepository productRepository = new ProductRepository();

    public void create(String name, BigDecimal tax, String description, BigDecimal amount, String categoryStr)
    {
        try {
            productRepository.save(new Product(name, tax, description, amount, ItemCategory.valueOf(categoryStr)));
        } catch (ProductException e) {
            e.printStackTrace();
        }
    }
    
    public Product readById(Long id){
        try {
            return productRepository.findById(id);
        } catch (ProductException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

    public void update(Long id, String name, BigDecimal tax, String description, BigDecimal amount, String productCategory) {
        //TODO:: NAPISAć metodę do robienia updatea
        //productRepository.
    }

    public void delete(Long id) throws ProductException {
        productRepository.deleteById(id);
    }
    
    public Product readByName(String productName) {
        return productRepository.findByName(productName);
    }
    
    public List<Product> readAll() {
        return productRepository.findAll();
    }
    
    public List<Product> readByKeywordInDescription(String keyword) {
        //TODO:napisać metodę w product repository do szukania produktów po słowie kluczowym w opisie
        return null;
    }


}
