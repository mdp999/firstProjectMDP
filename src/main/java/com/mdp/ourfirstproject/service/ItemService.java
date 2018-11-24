package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.model.ItemCategory;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.Item.IItemRepository;
import com.mdp.ourfirstproject.repository.Item.ItemException;
import com.mdp.ourfirstproject.repository.Item.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

public class ItemService {

    private IItemRepository itemRepository = new ItemRepository();

    public void create(Long productId, BigDecimal price, BigDecimal amount, String itemCategory){
        ProductService productService = new ProductService();
        Product product = productService.readById(productId);
        try {
            itemRepository.save(new Item( product, price, amount, ItemCategory.valueOf(itemCategory)));
        } catch (ItemException e) {
            e.printStackTrace();
        }
    }

    public Item readByID(Long id) {
        try {
            return itemRepository.findById(id);
        } catch (ItemException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Long itemId, Long productId, BigDecimal price, BigDecimal amount, String itemCategory){
        ProductService productService = new ProductService();
        Product product = productService.readById(productId);
        try {
            itemRepository.update(new Item( itemId, product, price, amount, ItemCategory.valueOf(itemCategory)));
        } catch (ItemException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id){
        try {
            itemRepository.deleteById(id);
        } catch (ItemException e) {
            e.printStackTrace();
        }
    }

    public List<Item> readByName(String itemName) {
        itemRepository.findByName(itemName);
        return null;
    }

    public List<Item> readAll() {
        return itemRepository.findAll();
    }

    public List<Item> readByKeywordInDescription(String keyword) {
        return itemRepository.findByKeywordInDescription(keyword);
    }

}
