package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.repository.Item.IItemRepository;
import com.mdp.ourfirstproject.repository.Item.ItemException;
import com.mdp.ourfirstproject.repository.Item.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

public class ItemService {

    private IItemRepository itemRepository = new ItemRepository();

    public void create(Item item) {
        try {
            itemRepository.save(item);
        } catch (ItemException e) {
            e.printStackTrace();
        }
    }

    public void create(Long productId, BigDecimal price, BigDecimal amount) {
        //TODO: zaimplementować tą metodę przy użyciu ProductRepository- pobrać produkt po jego ID, a potem zapisać
    }

    public Item readByID(Long id) {
        return itemRepository.findById(id);
    }

    public void update(Item item) {
        //TODO:znaleźć metodę w itemRepository do updatów
    }

    public void update(Long itemId, Long productId, BigDecimal price, BigDecimal amount) {
        //TODO: zaimplementować tą metodę przy użyciu ProductRepository- pobrać produkt po jego ID, a potem zapisać
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> readByName(String productName) {
        //TODO:napisać metodę w item repository do szukania itemów po nazwie produktu
        return null;
    }

    public List<Item> readAll() {
        //return itemRepository.findAll();//TODO: przekonwertować to do listyItemów
        return null;
    }

    public List<Item> readByKeywordInDescription(String keyword) {
        //TODO:napisać metodę w item repository do szukania itemów po słowie kluczowym w opisie
        return null;
    }

}
