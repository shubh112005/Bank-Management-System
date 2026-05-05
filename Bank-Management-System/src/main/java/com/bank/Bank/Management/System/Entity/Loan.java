package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "loan")
public class Loan  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    private String status;
    private LocalDateTime appliedDate;
    private LocalDateTime approvedDate;


    @ManyToOne
    @JoinColumn(name = "customer_ id")
    private Customer customer;

}
