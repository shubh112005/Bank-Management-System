package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.Account;
import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Exception.AccountNotFoundException;
import com.bank.Bank.Management.System.Repository.AccountRepository;
import com.bank.Bank.Management.System.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Account createAccount(Long customerId, Account account){

        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException("Customer not Found"));
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    public Account  getAccountById(Long id){
        return accountRepository.findById(id).
                orElseThrow(() -> new AccountNotFoundException("Account not found "));

    }

    public List<Account> getAccountByCustomer(Long customerId){
        return accountRepository.findByCustomerId(customerId);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
