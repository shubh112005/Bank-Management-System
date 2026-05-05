package com.bank.Bank.Management.System.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuditDTO {
    private Long id;
    private String action;
    private String performedBy;
    private LocalDateTime timestamp;
    private Long loanId;

}
