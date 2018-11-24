package com.mdp.ourfirstproject.repository.Product;

import com.mdp.ourfirstproject.model.Product;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.repository.util.PersistenceUtilFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
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
        Product transfer = entityManager.find(Product.class, id);
        if(transfer ==null)
        {
            throw new ProductException("Problem z pobraniem");
        }
        return transfer;
    }

    @Override
    public Product findByName(String productName) {
//        Product product = entityManager.createQuery("Select product from Product product where product.name LIKE :pName", Product.class)
//                .setParameter("pName", "%"+productName+"%").getSingleResult();
        Product product = entityManager.createQuery("Select product from Product product where product.name LIKE :pName", Product.class)
                .setParameter("pName", "%"+productName+"%").getSingleResult();
        //System.out.println(product.toString());
        return product;
    }

    @Override
    public List<Product> findByProductCategory(ProductCategory productCategory) {
        List<Product> products = new ArrayList<>();
        Query query = entityManager.createQuery("Select product from Product product where product.category=:pCategory", Product.class);
        query.setParameter("pCategory", productCategory);
        products = query.getResultList();
        return products;
    }

    @Override
    public List<Product> findByProducer(String producerName) {
        List<Product> transfers = new ArrayList<>();
        Query query = entityManager.createQuery("Select product from Product product left outer join product.producer producer where producer.name=:pName", Product.class);
        query.setParameter("pName", producerName);
        transfers = query.getResultList();
        return transfers;
    }

    @Override
    public List<Product> findAll() {
        List<Product> results = entityManager
                .createQuery("Select product from Product product", Product.class)
                .getResultList();
        return results;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
    }

}
