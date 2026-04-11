package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Loan  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    @Setter
    @Getter
    private Boolean approved;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
