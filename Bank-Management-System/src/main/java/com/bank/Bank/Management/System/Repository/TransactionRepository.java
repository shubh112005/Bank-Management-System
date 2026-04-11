package com.bank.Bank.Management.System.Repository;

import com.bank.Bank.Management.System.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountId(Long accountId);
}
