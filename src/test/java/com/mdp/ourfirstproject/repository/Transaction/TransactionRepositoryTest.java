package com.mdp.ourfirstproject.repository.Transaction;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TransactionRepositoryTest {

    private TransactionRepository transactionRepository;

    @Before
    public void setUp(){

        transactionRepository = new TransactionRepository();
    }

    @Ignore
    public void save() throws TransactionException {
        //given
//        String message = "Test testRepositoryAdd zawiódł";
//
//        //when
//        transactionRepository.save(new Transaction("Transakcja 1", "Opis transakcji 1", CashType.CASH,
//                    TransactionType.EXPENDITURE, new Date()));
//
//        //then
//        String name = transactionRepository.findById(new Long(1)).getName();
//        assertEquals(name,"Transakcja 1");
//        System.out.println(name);
//        fail(message);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByProductCategory() {
    }

    @Test
    public void findByTransactionType() {
    }

    @Test
    public void findByCashType() {
    }

    @Test
    public void findByDate() {
    }

    @Test
    public void findByCashAmount() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void cleanUp() {
    }
}