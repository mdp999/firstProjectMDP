package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.CashType;
import com.mdp.ourfirstproject.model.ProductCategory;
import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.model.TransactionType;
import com.mdp.ourfirstproject.repository.Transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionService {


    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    
    public void create() {
        throw new NotImplementedException();
    }

    public Transaction readById(long id) {
        return transactionRepository.getByID(id);
    }

    public void update() {
        throw new NotImplementedException();
    }

    public void delete(long id) {
        transactionRepository.delete(id);
        return "";
    }

    public List<Transaction> getByProductCategory(String categoryStr) {
        ProductCategory cat = null;
        for(ProductCategory productCategory : ProductCategory.values()) {
            if(productCategory.toString().equals(categoryStr))
                cat = productCategory;
        }
        return transactionRepository.getByProductCategory(cat);
    }

    public List<Transaction> getByTransferType(String transferString) {
        TransactionType tType = null;
        for(TransactionType transferType : TransactionType.values()) {
            if(transferType.toString().equals(transferString))
                tType = transferType;
        }
        return transactionRepository.getByTransferType(tType);
    }

    public List<Transaction> getByCashType(String cashString)
    {
        CashType cType = null;
        for(CashType cashType : CashType.values()) {
            if(cashType.toString().equals(cashString))
                cType = cashType;
        }
        return transactionRepository.getByCashType(cType);
    }

    public List<Transaction> getByDate(Date minDate, Date maxDate)
    {
        return transactionRepository.getByDate(minDate,maxDate);
    }

    public List<Transaction> getByCashAmount(BigDecimal minAmount, BigDecimal maxAmount)
    {
        return transactionRepository.getByCashAmount(minAmount, maxAmount);
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
    
    
}
