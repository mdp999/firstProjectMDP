package com.mdp.ourfirstproject.repository.Item;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.model.ItemCategory;

import java.util.List;

public interface IItemRepository {

    boolean save(Item item) throws ItemException;
    boolean deleteById(long id) throws ItemException;

    boolean update(Item item) throws ItemException;

    Item findById(long id) throws ItemException;

    List<Item> findByName(String itemName);
    List<Item> findByKeywordInDescription(String keyword);
    List<Item> findByProductCategory(ItemCategory itemCategory);
    List<Item> findByProduct(String productName);

    List<Item> findAll();
    void cleanUp();


}