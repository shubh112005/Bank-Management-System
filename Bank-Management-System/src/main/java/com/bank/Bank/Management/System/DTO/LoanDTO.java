package com.bank.Bank.Management.System.DTO;

import lombok.Data;

@Data
public class LoanDTO {

    private Long id;
    private Double amount;
    private String status;
    private Long customerId;

}
