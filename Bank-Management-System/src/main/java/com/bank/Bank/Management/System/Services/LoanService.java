package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Entity.Loan;
import com.bank.Bank.Management.System.Exception.CustomerNotFoundException;
import com.bank.Bank.Management.System.Exception.LoanNotFoundException;
import com.bank.Bank.Management.System.Repository.CustomerRepository;
import com.bank.Bank.Management.System.Repository.LoanRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Loan applyLoan(Long customerId, Loan loan){
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        loan.setCustomer(customer);
        loan.setApproved(false);
        return loanRepository.save(loan);
    }

    public Loan approveLoan(long loanId){
        Loan loan = loanRepository.findById(loanId).
                orElseThrow(() -> new LoanNotFoundException("Loan not found"));

        loan.setApproved(true);
        return loanRepository.save(loan);
    }

    public List<Loan> getLoanByCustomer(Long customerId){
        return loanRepository.findByCustomerId(customerId);
    }
}
