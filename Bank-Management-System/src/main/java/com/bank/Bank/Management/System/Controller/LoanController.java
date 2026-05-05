package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.Entity.Loan;
import com.bank.Bank.Management.System.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Apply for loan
    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@RequestParam Long customerId,
                                          @RequestParam Double amount) {
        return ResponseEntity.ok(loanService.applyLoan(customerId, amount));
    }

    // Approve loan
    @PostMapping("/{id}/approve")
    public ResponseEntity<Loan> approveLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.approveLoan(id));
    }

    // Reject loan
    @PostMapping("/{id}/reject")
    public ResponseEntity<Loan> rejectLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.rejectLoan(id));
    }

    // Get loans by customer
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Loan>> getLoansByCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoansByCustomer(id));
    }

    // Get all loans
    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
}