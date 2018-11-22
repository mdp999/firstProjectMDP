package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.Exceptions.NoSuchProductException;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RestController
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/create")
    public String createProductGet(Product product) {
        //:TODO: wczytanie szablonu w którym można dodać nowy produkt
        //throw new NotImplementedException();
        return "product/productAdd";
    }

    @GetMapping(value = "/product/read/id/{id}")
    public Product readProductByIdGet(@PathVariable("id") Long id) throws NoSuchProductException {
        return productService.readById(id);
    }

    @PutMapping(value = "/product/update/{id}")
    public void updateProductPut(@RequestBody Product product, @PathVariable Long id) {
        productService.update(product,id);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProductDelete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping(value = "/product/read/name/{name}")
    public List<Product> readProductByName(@PathVariable String name) {
        return null;
    }

    @RequestMapping(value = "/product/readall")
    public List<Product> readProductAll() {
        return productService.readAll();
    }


    @RequestMapping(value = "/product/read/keyword/{keyword}")
    public String readProductByKeywordInDescription(@PathVariable String keyword) {
        productService.readByKeywordInDescription(keyword);
        throw new NotImplementedException();
//        return "Hello world";
    }

//    @RequestMapping("/")
//    public String hello()
//    {
//        return "Hello world";
//    }


}
