package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(String name, BigDecimal tax, String description, BigDecimal amount, String categoryStr)
    {
        productRepository.save(new Product(name, tax, description, amount, ProductCategory.valueOf(categoryStr)));
    }
    
    public Product readById(Long id){
        return productRepository.findById(id).get();
    }

    public void update(Long id, String name, BigDecimal tax, String description, BigDecimal amount, String productCategory) {
        //TODO:: NAPISAć metodę do robienia updatea
        //productRepository.
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    
    public List<Product> readByName(String productName) {
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
