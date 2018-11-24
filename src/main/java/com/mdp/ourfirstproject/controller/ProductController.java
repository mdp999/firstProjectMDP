package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/create")
    public String createProductGet()
    {
        return "product/productAdd";
    }

    @PostMapping(value = "/product/create")
    public String createProductPost(@RequestParam String name, @RequestParam BigDecimal tax,
                                   @RequestParam String description, @RequestParam BigDecimal amount,
                                   @RequestParam String productCategory) {
        productService.create(name, tax, description, amount, productCategory);
        //:TODO: wczytanie szablonu w którym można dodać nowy produkt
        return "product/productAdd";
    }

    @GetMapping(value = "/product/read/id/{id}")
    public Product readProductByIdGet(@PathVariable("id") Long id){
        return productService.readById(id);
    }

    @PutMapping(value = "/product/update/{id}")
    public void updateProductPut(@RequestParam Long id, @RequestParam String name, @RequestParam BigDecimal tax,
                                 @RequestParam String description, @RequestParam BigDecimal amount,
                                 @RequestParam String productCategory) {
        productService.update(id, name, tax, description, amount, productCategory);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProductDelete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping(value = "/product/read/name/{name}")
    public List<Product> readProductByName(@PathVariable String name) {
        return productService.readByName(name);
    }

    @RequestMapping(value = "/product/readall")
    public List<Product> readProductAll() {
        return productService.readAll();
    }

    @RequestMapping(value = "/product/read/keyword/{keyword}")
    public String readProductByKeywordInDescription(@PathVariable String keyword) {
        productService.readByKeywordInDescription(keyword);
        return "";
    }



}
