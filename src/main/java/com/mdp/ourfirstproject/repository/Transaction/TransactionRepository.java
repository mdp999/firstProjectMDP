package com.mdp.ourfirstproject.repository.Transaction;

import com.mdp.ourfirstproject.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {



}
