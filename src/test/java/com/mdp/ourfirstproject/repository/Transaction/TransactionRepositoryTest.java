package com.mdp.ourfirstproject.repository.Transaction;

import com.mdp.ourfirstproject.model.CashType;
import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.model.TransactionType;
import com.mdp.ourfirstproject.service.TransactionService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
//        SpringBootTest.WebEnvironment.MOCK,
        classes = TransactionRepositoryTest.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Before
    public void setUp(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringRunner.class);
        transactionRepository = context.getBean(TransactionRepository.class);
    }

    @Test
    public void testRepositoryAdd(){
        //given
        String message = "Test testRepositoryAdd zawiódł";

        //when
        transactionRepository.save(new Transaction("Transakcja 1", "Opis transakcji 1", CashType.CASH,
                    TransactionType.EXPENDITURE, new Date()));

        //then
        assertEquals(transactionRepository.findById(new Long(1)).get().getName(),"Transakcja 1");

        fail(message);
    }

}