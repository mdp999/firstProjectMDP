package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class ProductControllerTest {


    private ProductController productController;

    @Autowired
    public ProductControllerTest(ProductController productController) {
        this.productController = productController;
    }

    @Before
    public void setUp() {
    }

    @Test
    public void createProductGet() {
        productController.createProductPost("Masło", new BigDecimal(7), "Masło świeże", new BigDecimal(200), "FOOD");
        System.out.println(productController.readProductByIdGet(new Long( 1)).toString());
        //System.out.println(productController.readProductAll().get(0).toString());
    }

    @Test
    public void readProductByIdGet() {
    }

    @Test
    public void updateProductPut() {
    }

    @Test
    public void deleteProductDelete() {
    }

    @Test
    public void readProductByName() {
    }

    @Test
    public void readProductAll() {
    }

    @Test
    public void readProductByKeywordInDescription() {
    }
}