package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

@Controller
public class ItemController {

    private ItemService itemService = new ItemService();

    @RequestMapping("/")
    public String hello()
    {
        return "Hello world";
    }

    @GetMapping(value = "/item/create")
    public String createItemGet()
    {
        //:TODO: wczytanie szablonu w którym można dodać nową transakcję
        throw new NotImplementedException();
    }

    @PostMapping(value = "/item/create")
    public String createItemPost(@RequestParam Long productId, @RequestParam BigDecimal price,
                                 @RequestParam BigDecimal amount)
    {
        itemService.create(productId, price, amount);
        throw new NotImplementedException();
    }

    @GetMapping(value = "/item/read/id/{id}/")
    public String readItemByIdGet(@RequestParam Long id)
    {
        itemService.readByID(id);
        throw new NotImplementedException();
    }

    @GetMapping(value = "/item/read/name/{name}/")
    public String readItemByNameGet(@RequestParam String productName)
    {
        itemService.readByName(productName);
        throw new NotImplementedException();
    }

    @GetMapping(value = "/item/read/keyword/{keyword}/")
    public String readItemByKeywordGet(@RequestParam String keyword)
    {
        itemService.readByKeywordInDescription(keyword);
        throw new NotImplementedException();
    }

    @GetMapping(value = "/item/readall/")
    public String readItemByKeywordGet()
    {
        itemService.readAll();
        throw new NotImplementedException();
    }

    @GetMapping(value = "/item/update")
    public String updateItemGet()
    {
        //:TODO: wczytanie szablonu w którym można dodać edytować transakcję
        throw new NotImplementedException();
    }

    @PostMapping(value = "/item/update")
    public String updateItemPost(@RequestParam Long itemId, @RequestParam Long productId, @RequestParam BigDecimal price, @RequestParam BigDecimal amount)
    {
        itemService.update(itemId, productId, price, amount);
        throw new NotImplementedException();
    }

    @DeleteMapping(value = "/item/delete/{id}")
    public String deleteItem(@PathVariable("id") long id) {
        itemService.delete(id);
        return "";
    }

}
