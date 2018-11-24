package com.mdp.ourfirstproject.repository.Item;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.model.ItemCategory;
import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.util.PersistenceUtilFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements IItemRepository {

    //private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public ItemRepository() {
        entityManager = PersistenceUtilFactory.getEntityManager();
    }

    @Override
    public boolean save(Item item) throws ItemException {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ItemException(e.getMessage());
        }
    }


    @Override
    public boolean deleteById(long id) throws ItemException {
        EntityTransaction transaction = null;
        Item item = findById(id);
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ItemException("Problem z usunięciem");
        }
    }

    @Override
    public boolean update(Item item) throws ItemException {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ItemException("Problem z modyfikacją");
        }
    }

    @Override
    public Item findById(long id) throws ItemException {
        Item transfer = entityManager.find(Item.class, id);
        if(transfer ==null)
        {
            throw new ItemException("Problem z pobraniem");
        }
        return transfer;
    }

    @Override
    public List<Item> findByName(String itemName) {
        Query query = entityManager.createQuery("Select item from Item item where item.name LIKE :iName", Item.class)
                .setParameter("iName", "%"+itemName+"%");
        List<Item> items = query.getResultList();
        return items;
    }

    @Override
    public List<Item> findByProductCategory(ItemCategory itemCategory) {
        throw new NotImplementedException();
    }

    @Override
    public List<Item> findByProduct(String productName) {
        throw new NotImplementedException();
//        return null;
    }

    @Override
    public List<Item> findAll() {
        List<Item> results = entityManager
                .createQuery("Select item from Item item", Item.class)
                .getResultList();
        return results;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }

    @Override
    public List<Item> findByKeywordInDescription(String keyword) {
        Query query = entityManager.createQuery("Select item from Item item where item.description LIKE :iName", Item.class)
                .setParameter("iName", "%"+keyword+"%");
        List<Item> items = query.getResultList();
        return items;
    }

}
