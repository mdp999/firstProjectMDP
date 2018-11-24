package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.ItemCategory;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.Product.IProductRepository;
import com.mdp.ourfirstproject.repository.Product.ProductException;
import com.mdp.ourfirstproject.repository.Product.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private IProductRepository productRepository = new ProductRepository();

    public boolean create(String name, BigDecimal tax, String description, BigDecimal amount, String categoryStr)
    {
        try {
            productRepository.save(new Product(name, tax, description, amount, ItemCategory.valueOf(categoryStr)));
            return true;
        } catch (ProductException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Product readById(Long id){
        try {
            return productRepository.findById(id);
        } catch (ProductException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Long id, String name, BigDecimal tax, String description, BigDecimal amount, String itemCategory) {
        try {
            productRepository.update(new Product(id, name, tax, description, amount, ItemCategory.valueOf(itemCategory)));
            return true;
        } catch (ProductException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (ProductException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Product> readByName(String productName) {
        return productRepository.findByName(productName);
    }
    
    public List<Product> readAll() {
        return productRepository.findAll();
    }
    
    public List<Product> readByKeywordInDescription(String keyword) {
        return productRepository.readByKeywordInDescription(keyword);
    }

}
