package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.Entity.Loan;
import com.bank.Bank.Management.System.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply/{customerId}")
    public Loan applyLoan(@PathVariable Long customerId, @RequestBody Loan loan){
        return loanService.applyLoan(customerId, loan);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/approve")
    public Loan approveLoan(@PathVariable Long loanId){
        return loanService.approveLoan(loanId);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoanByCustomer(@PathVariable Long customerId){
        return loanService.getLoanByCustomer(customerId);
    }
}
