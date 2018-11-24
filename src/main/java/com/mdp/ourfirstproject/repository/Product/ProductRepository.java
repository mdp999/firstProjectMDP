package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.repository.util.PersistenceUtilFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private EntityManager entityManager;

    public ProductRepository() {
        entityManager = PersistenceUtilFactory.getEntityManager();
    }

    @Override
    public boolean save(Product product) throws ProductException {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ProductException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ProductException {
        EntityTransaction transaction = null;
        Product product = findById(id);
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ProductException("Problem z usunięciem");
        }
    }

    @Override
    public boolean update(Product product) throws ProductException {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ProductException("Problem z modyfikacją");
        }
    }

    @Override
    public Product findById(long id) throws ProductException {
        Product product = entityManager.find(Product.class, id);
        if(product ==null)
        {
            throw new ProductException("Problem z pobraniem");
        }
        return product;
    }

    @Override
    public List<Product> readByKeywordInDescription(String keyword) {
        List<Product> products = entityManager.createQuery("Select product from Product product where product.description LIKE :pDescription", Product.class)
                .setParameter("pDescription", "%"+keyword+"%").getResultList();
        return products;
    }

    @Override
    public List<Product> findByName(String productName) {
        List<Product> products = entityManager.createQuery("Select product from Product product where product.name LIKE :pName", Product.class)
                .setParameter("pName", "%"+productName+"%").getResultList();
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = entityManager
                .createQuery("Select product from Product product", Product.class)
                .getResultList();
        return products;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }

}
