package com.mdp.ourfirstproject.controller;

import com.mdp.ourfirstproject.model.Transaction;
import com.mdp.ourfirstproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    private TransactionService transactionService = new TransactionService();

    @GetMapping(value = "/transaction/create")
    public String createTransactionGet(@RequestParam String name, @RequestParam String description,
                                       @RequestParam String cashType,
                                       @RequestParam String transactionType, @RequestParam Date transferDate) {
        transactionService.create(name, description, cashType, transactionType, transferDate);
        //:TODO: wczytanie szablonu w którym można dodać nowy produkt
        return "transaction/transactionAdd";
    }

    @GetMapping(value = "/transaction/read/id/{id}")
    public Transaction readTransactionByIdGet(@PathVariable("id") Long id) {
        return transactionService.readById(id);
    }

    @PutMapping(value = "/transaction/update/{id}")
    public void updateTransactionPut(@RequestParam Long id,@RequestParam String name, @RequestParam String description,
                                     @RequestParam String cashType, @RequestParam String transactionType,
                                     @RequestParam Date transferDate) {
        transactionService.update(id, name, description, cashType, transactionType, transferDate);
    }

    @DeleteMapping("/transaction/delete/{id}")
    public void deleteTransactionDelete(@PathVariable Long id) {
        transactionService.delete(id);
    }

    @GetMapping(value = "/transaction/read/name/{name}")
    public List<Transaction> readTransactionByName(@PathVariable String name) {
        return transactionService.readByName(name);
    }

    @RequestMapping(value = "/transaction/readall")
    public List<Transaction> readTransactionAll() {
        return transactionService.readAll();
    }

    @RequestMapping(value = "/transaction/read/keyword/{keyword}")
    public String readTransactionByKeywordInDescription(@PathVariable String keyword) {
        transactionService.readByKeywordInDescription(keyword);
        throw new NotImplementedException();
    }

}
