package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
public class ProductController {

    private ProductService productService = new ProductService();

    @GetMapping(value = "/product/create")
    public String createProductGet()
    {
        return "add new product";
    }

    @PostMapping(value = "/product/create")
    public String createProductPost(@RequestParam String name, @RequestParam BigDecimal tax,
                                   @RequestParam String description, @RequestParam BigDecimal amount,
                                   @RequestParam String productCategory) {
        if(productService.create(name, tax, description, amount, productCategory))
            return "Poszło";
        else
            return "Wystąpił błąd";
    }

    @GetMapping(value = "/product/read/id/{id}")
    public String readProductByIdGet(@PathVariable("id") Long id){
        return productService.readById(id).toString();
    }

    @PutMapping(value = "/product/update/{id}")
    public String updateProductPut(@RequestParam Long id, @RequestParam String name, @RequestParam BigDecimal tax,
                                 @RequestParam String description, @RequestParam BigDecimal amount,
                                 @RequestParam String productCategory) {

        if(productService.update(id, name, tax, description, amount, productCategory))
            return "Poszło!";
        else
            return "Nie działa";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProductDelete(@PathVariable Long id) {
        if(productService.delete(id))
            return "Poszło!";
        else
            return "Nie działa";
    }

    @GetMapping(value = "/product/read/name/{name}")
    public String readProductByName(@PathVariable String name) {
        StringBuilder sb = new StringBuilder();
        productService.readByName(name).forEach(x->sb.append(x.toString()).append("\n"));
        return sb.toString();
    }

    @GetMapping(value = "/product/readall")
    public String readProductAll() {
        StringBuilder sb = new StringBuilder();
        productService.readAll().stream().forEach(x->sb.append(x.toString()).append("\n"));
        return sb.toString();
    }

    @GetMapping(value = "/product/read/keyword/{keyword}")
    public String readProductByKeywordInDescription(@PathVariable String keyword) {
        StringBuilder sb = new StringBuilder();
        productService.readByKeywordInDescription(keyword).stream().forEach(x->sb.append(x.toString()).append("\n"));
        return sb.toString();
    }



}
