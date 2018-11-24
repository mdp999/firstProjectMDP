package com.mdp.ourfirstproject.repository.Item;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.model.ProductCategory;

import java.util.List;

public interface IItemRepository {

    boolean save(Item item) throws ItemException;
    boolean deleteById(long id) throws ItemException;

    boolean update(Item item) throws ItemException;

    Item findById(long id) throws ItemException;

    Item findByName(String itemName);
    List<Item> findByProductCategory(ProductCategory itemCategory);

    List<Item> findByProduct(String productName);

    List<Item> findAll();
    void cleanUp();


}