package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.Account;
import com.bank.Bank.Management.System.Entity.Transaction;
import com.bank.Bank.Management.System.Exception.AccountNotFoundException;
import com.bank.Bank.Management.System.Exception.InsufficientBalanceException;
import com.bank.Bank.Management.System.Repository.AccountRepository;
import com.bank.Bank.Management.System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.datatransfer.Transferable;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    // Deposit
    public Transaction deposit(Long accountId, Double amount){
        Account account = accountRepository.findById(accountId).
                orElseThrow(() -> new AccountNotFoundException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setType("Deposit");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }
    //Withdraw
    public Transaction withdraw(Long accountId, Double amount ){

        Account account = accountRepository.findById(accountId).
                orElseThrow(() -> new AccountNotFoundException("Account not found"));
        if (account.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setType("Withdraw");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }
    //Transfer
    public Transaction transfer(Long fromAccountId, Long toAccountId, Double amount){

        Account fromAccount = accountRepository.findById(fromAccountId).
                orElseThrow(() -> new AccountNotFoundException("Sender not found"));

        Account toAccount = accountRepository.findById(toAccountId).
                orElseThrow(() -> new AccountNotFoundException("Receiver not found"));

        if(fromAccount.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient amount in Sender account");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountRepository.save(fromAccount);

        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setType("transfer");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAccount(fromAccount);

        return transactionRepository.save(transaction);
    }
}
