/*
package com.bank.Bank.Management.System;


import com.bank.Bank.Management.System.Entity.Account;
import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Entity.Transaction;
import com.bank.Bank.Management.System.Services.AccountService;
import com.bank.Bank.Management.System.Services.CustomerService;
import com.bank.Bank.Management.System.Services.TransactionService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BankManagementSystemApplicationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Test
    void contextLoads() {
        // ✅ Basic check: Spring context starts
        assertThat(customerService).isNotNull();
        assertThat(accountService).isNotNull();
        assertThat(transactionService).isNotNull();
    }

    @Test
    void testCustomerCreation() {
        Customer customer = new Customer();
        customer.setName("Shubham");
        customer.setEmail("shubham@example.com");
        customer.setPhone("9876543210");
        customer.setAddress("Kashipur");

        Customer savedCustomer = customerService.addCustomer(customer);

        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getName()).isEqualTo("Shubham");
    }

    @Test
    void testAccountCreation() {
        Customer customer = new Customer();
        customer.setName("Test User");
        customer.setEmail("test@example.com");
        customer.setPhone("1234567890");
        customer.setAddress("Test City");
        Customer savedCustomer = customerService.addCustomer(customer);

        Account account = new Account();
        account.setAccountNumber("ACC1001");
        account.setType("SAVINGS");
        account.setBalance(1000.0);

        Account savedAccount = accountService.createAccount(savedCustomer.getId(), account);

        assertThat(savedAccount.getId()).isNotNull();
        assertThat(savedAccount.getBalance()).isEqualTo(1000.0);
    }

    @Test
    void testDepositTransaction() {
        Customer customer = new Customer();
        customer.setName("Deposit User");
        customer.setEmail("deposit@example.com");
        customer.setPhone("111222333");
        customer.setAddress("Deposit City");
        Customer savedCustomer = customerService.addCustomer(customer);

        Account account = new Account();
        account.setAccountNumber("ACC2001");
        account.setType("SAVINGS");
        account.setBalance(500.0);
        Account savedAccount = accountService.createAccount(savedCustomer.getId(), account);

        Transaction transaction = transactionService.deposit(savedAccount.getId(), 200.0);

        assertThat(transaction.getType()).isEqualTo("DEPOSIT");
        assertThat(transaction.getAmount()).isEqualTo(200.0);
        assertThat(transaction.getAccount().getBalance()).isEqualTo(700.0);
    }
}
*/