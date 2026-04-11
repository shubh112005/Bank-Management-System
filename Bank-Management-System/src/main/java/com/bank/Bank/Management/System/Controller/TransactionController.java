package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.Entity.Transaction;
import com.bank.Bank.Management.System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/deposit/{accountId}")
    public Transaction deposit(Long accountId, @RequestParam Double amount){
        return transactionService.deposit(accountId, amount);
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam Long fromAccountId,
                                @RequestParam Long toAccountId,
                                @RequestParam Double amount){
        return transactionService.transfer(fromAccountId, toAccountId, amount);
    }
}
