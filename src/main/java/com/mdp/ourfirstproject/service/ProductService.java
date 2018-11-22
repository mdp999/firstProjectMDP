package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) {
        productRepository.save(product);
    }
    
    public Product readById(Long id) throws NoSuchProductException {
        return productRepository.findById(id).get();
    }
    
    public void update(Product product, Long id) {
        //todo:
    }

    public void delete(Long id) {
        //todo
    }
    
    public List<Product> readByName(String productName) {
        //todo
        return null;
    }

    
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    
    public List<Product> readByKeywordInDescription(String keyword) {
        //TODO:napisać metodę w product repository do szukania produktów po słowie kluczowym w opisie
        return null;
    }



}
