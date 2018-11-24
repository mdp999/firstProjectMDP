package com.mdp.ourfirstproject.repository.Item;

import com.mdp.ourfirstproject.model.Item;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.repository.util.PersistenceUtilFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    public Item findByName(String itemName) {
//        Product product = entityManager.createQuery("Select product from Product product where product.name LIKE :pName", Product.class)
//                .setParameter("pName", "%"+productName+"%").getSingleResult();
        Item item = entityManager.createQuery("Select item from Item item where item.name LIKE :iName", Item.class)
                .setParameter("iName", "%"+itemName+"%").getSingleResult();
        return item;
    }

    @Override
    public List<Item> findByProductCategory(ProductCategory productCategory) {
        throw new NotImplementedException();
//        List<Product> products = new ArrayList<>();
//        Query query = entityManager.createQuery("Select item from Item item where item.category=:pCategory", Item.class);
//        query.setParameter("pCategory", productCategory);
//        products = query.getResultList();
//        return products;
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

}
