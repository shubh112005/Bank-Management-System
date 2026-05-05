package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.DTO.TransactionDTO;
import com.bank.Bank.Management.System.Entity.Transaction;
import com.bank.Bank.Management.System.Mapper.TransactionMapper;
import com.bank.Bank.Management.System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired private TransactionService transactionService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/{id}/deposit")
    public ResponseEntity<TransactionDTO> deposit(@PathVariable Long id, @RequestParam Double amount) {
        Transaction tx = transactionService.deposit(id, amount);
        return ResponseEntity.ok(TransactionMapper.toDTO(tx));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@PathVariable Long id, @RequestParam Double amount) {
        Transaction tx = transactionService.withdraw(id, amount);
        return ResponseEntity.ok(TransactionMapper.toDTO(tx));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> transfer(@RequestParam Long fromId,
                                                   @RequestParam Long toId,
                                                   @RequestParam Double amount) {
        Transaction tx = transactionService.transfer(fromId, toId, amount);
        return ResponseEntity.ok(TransactionMapper.toDTO(tx));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/account/{id}")
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable Long id) {
        List<TransactionDTO> dtos = transactionService.getTransactionsByAccount(id)
                .stream().map(TransactionMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }
}
