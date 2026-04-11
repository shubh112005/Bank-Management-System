package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Double amount;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
