package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.*;
import com.bank.Bank.Management.System.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Deposit
    @Transactional
    public Transaction deposit(Long accountId, Double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.DEPOSIT);
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setAccount(account);

        return transactionRepository.save(tx);
    }

    // Withdraw
    @Transactional
    public Transaction withdraw(Long accountId, Double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.WITHDRAW);
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setAccount(account);

        return transactionRepository.save(tx);
    }

    // Transfer
    @Transactional
    public Transaction transfer(Long fromId, Long toId, Double amount) {

        if (fromId.equals(toId)) {
            throw new RuntimeException("Cannot transfer to same account");
        }

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // Update balances
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Create transaction record
        Transaction tx = new Transaction();
        tx.setType(TransactionType.TRANSFER);
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setAccount(fromAccount);
        tx.setTargetAccountId(toId);

        return transactionRepository.save(tx);
    }

    // Get all transactions by account
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}