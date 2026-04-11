package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.Entity.Account;
import com.bank.Bank.Management.System.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/customers/{customerId}")
    public Account createAccount(@PathVariable Long customerId,@RequestBody Account account){

        return accountService.createAccount(customerId, account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getAccountByCustomer(@PathVariable Long customerId){
        return accountService.getAccountByCustomer(customerId);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
         accountService.deleteAccount(id);
    }
}
