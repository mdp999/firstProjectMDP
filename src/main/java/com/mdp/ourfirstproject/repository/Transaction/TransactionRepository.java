package com.mdp.ourfirstproject.repository.Transaction;

import com.mdp.ourfirstproject.model.CashType;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.model.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public TransactionRepository() {
        managerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public boolean save(Transaction transaction) throws TransactionException {
        EntityTransaction entityTransaction = null;
        transaction.setCreationDate(new Date());
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entityTransaction);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            throw new TransactionException("Problem z dodaniem");
        }
    }

    @Override
    public boolean deleteById(long id) throws TransactionException {
        EntityTransaction entityTransaction = null;
        Transaction transaction = findById(id);
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(entityTransaction);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            throw new TransactionException("Problem z usunięciem");
        }
    }

    @Override
    public boolean update(Transaction transaction) throws TransactionException {
        EntityTransaction entityTransaction = null;
        transaction.setModificationDate(new Date());
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(entityTransaction);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            throw new TransactionException("Problem z modyfikacją");
        }
    }

    @Override
    public Transaction findById(long id) throws TransactionException {
        Transaction transaction = entityManager.find(Transaction.class, id);
        if(transaction ==null)
        {
            throw new TransactionException("Problem z pobraniem");
        }
        return transaction;
    }

    @Override
    public List<Transaction> findByProductCategory(ProductCategory productCategory) {
            List<Transaction> transactions = new ArrayList<>();
            Query query = entityManager.createQuery("Select transaction from Transaction transaction left outer join transaction.product product where product.category=:pCategory", Transaction.class);
            query.setParameter("pCategory", productCategory);
            transactions = query.getResultList();
            return transactions;
    }

    @Override
    public List<Transaction> findByTransactionType(TransactionType transactionType) {
            List<Transaction> transactions = new ArrayList<>();
            Query query = entityManager.createQuery("Select transaction from Transaction transaction where transaction.transactionType=:tType", Transaction.class);
            query.setParameter("tType", transactionType);
            transactions = query.getResultList();
            return transactions;
    }

    @Override
    public List<Transaction> findByCashType(CashType cashType) {
            List<Transaction> transactions = new ArrayList<>();
            Query query = entityManager.createQuery("Select transaction from Transaction transaction where transaction.category=:cType", Transaction.class);
            query.setParameter("cType", cashType);
            transactions = query.getResultList();
            return transactions;
    }

    @Override
    public List<Transaction> findByDate(Date minDate, Date maxDate) {
        List<Transaction> transactions = new ArrayList<>();
        Query query = entityManager.createQuery("Select transaction from Transaction transaction where transaction.transactionDate>=:minD and transaction.transactionDate<=:maxD", Transaction.class);
        query.setParameter("minD", minDate);
        query.setParameter("maxD", maxDate);
        transactions = query.getResultList();
        return transactions;
    }

    @Override
    public List<Transaction> findByCashAmount(BigDecimal minAmount, BigDecimal maxAmount) {
        List<Transaction> transactions = new ArrayList<>();
        Query query = entityManager.createQuery("Select transaction from Transaction transaction where transaction.amount>=:minA and transaction.amount<=:maxA", Transaction.class);
        query.setParameter("minA", minAmount);
        query.setParameter("maxA", maxAmount);
        transactions = query.getResultList();
        return transactions;
    }


    @Override
    public List<Transaction> findAll() {
        List<Transaction> results = entityManager
                .createQuery("Select transaction from Transaction transaction", Transaction.class)
                .setFlushMode(FlushModeType.COMMIT)
                .getResultList();
        return results;
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }

}
