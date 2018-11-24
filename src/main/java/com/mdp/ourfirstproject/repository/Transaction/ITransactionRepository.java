package com.mdp.ourfirstproject.repository.Transaction;

import com.mdp.ourfirstproject.model.CashType;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.model.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ITransactionRepository {

    boolean save(Transaction transaction) throws TransactionException;
    boolean deleteById(long id) throws TransactionException;
    boolean update(Transaction transaction) throws TransactionException;
    Transaction findById(long id) throws TransactionException;
    List<Transaction> findByProductCategory(ProductCategory productCategory);
    List<Transaction> findByTransactionType(TransactionType transactionType);
    List<Transaction> findByCashType(CashType cashType);
    List<Transaction> findByDate(Date minDate, Date maxDate);
    List<Transaction> findByCashAmount(BigDecimal minAmount, BigDecimal maxAmount);
    List<Transaction> findAll();
    void cleanUp();


}