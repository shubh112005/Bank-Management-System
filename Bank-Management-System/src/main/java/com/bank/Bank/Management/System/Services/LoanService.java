package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.Loan;
import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Repository.LoanRepository;
import com.bank.Bank.Management.System.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Apply for loan
    public Loan applyLoan(Long customerId, Double amount) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Loan loan = new Loan();
        loan.setAmount(amount);
        loan.setCustomer(customer);
        loan.setStatus("PENDING");
        loan.setAppliedDate(LocalDateTime.now());

        return loanRepository.save(loan);
    }

    // Approve loan
    public Loan approveLoan(Long id) {

        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setStatus("APPROVED");
        loan.setApprovedDate(LocalDateTime.now());

        return loanRepository.save(loan);
    }

    // Reject loan
    public Loan rejectLoan(Long id) {

        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setStatus("REJECTED");

        return loanRepository.save(loan);
    }

    // Get loans by customer
    public List<Loan> getLoansByCustomer(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    // Get all loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}