package com.mdp.ourfirstproject.service;

import com.mdp.ourfirstproject.model.CashType;
import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.model.TransactionType;
import com.mdp.ourfirstproject.repository.Transaction.ITransactionRepository;
import com.mdp.ourfirstproject.repository.Transaction.TransactionException;
import com.mdp.ourfirstproject.repository.Transaction.TransactionRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionService {

    private ITransactionRepository transactionRepository = new TransactionRepository();
    
    public void create(String name, String description, String cashType,
                       String transactionType, Date transferDate) {
        try {
            transactionRepository.save(new Transaction(name, description, CashType.valueOf(cashType),
                    TransactionType.valueOf(transactionType), transferDate));
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    public Transaction readById(long id) {
        try {
            return transactionRepository.findById(id);
        } catch (TransactionException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

    public List<Transaction> readByName(String name) {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //transactionRepository.findByName();
    }

    public void update(Long id, String name, String description, String cashType, String transactionType, Date transferDate) {
        throw new NotImplementedException();
    }

    public void delete(long id) {
        try {
            transactionRepository.deleteById(id);
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getByTransferType(String transactionString) {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //return transactionRepository.getByTransferType(TransactionType.valueOf(transactionString));
    }

    public List<Transaction> getByCashType(String cashString)
    {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //return transactionRepository.getByCashType(CashType.valueOf(cashString));
    }

    public List<Transaction> getByDate(Date minDate, Date maxDate)
    {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //return transactionRepository.getByDate(minDate,maxDate);
    }

    public List<Transaction> getByCashAmount(BigDecimal minAmount, BigDecimal maxAmount)
    {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //return transactionRepository.getByCashAmount(minAmount, maxAmount);
    }

    public List<Transaction> readAll() {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
        //return transactionRepository.findAll();
    }

    public List<Transaction> readByKeywordInDescription(String keyword) {
        //TODO: Zaimplementować to!
        throw new NotImplementedException();
    }
}
