package com.bank.Bank.Management.System.DTO;

import com.bank.Bank.Management.System.Entity.TransactionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private TransactionType type;   // use enum here too
    private Double amount;
    private LocalDateTime timestamp;
    private Long accountId;
    private Long targetAccountId;
}

