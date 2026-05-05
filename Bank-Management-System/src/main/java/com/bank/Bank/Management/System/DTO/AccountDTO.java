package com.bank.Bank.Management.System.DTO;

import lombok.Data;

@Data
public class AccountDTO {

    private Long Id;
    private String type;
    private Double balance;
    private Long customerId;
}
