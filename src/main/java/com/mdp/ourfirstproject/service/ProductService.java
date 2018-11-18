package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;
import com.mdp.ourfirstproject.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    
    public void create(Product product) {

    }
    
    public Product readByID(long id) throws NoSuchProductException {
        return null;
    }
    
    public void update(Product product) {

    }
    
    public void delete(long id) {

    }
    
    public List<Product> readByName(String productName) {
        return null;
    }

    
    public List<Product> readAll() {
        return null;
    }

    
    public List<Product> readByKeywordInDescription(String keyword) {
        return null;
    }



}
