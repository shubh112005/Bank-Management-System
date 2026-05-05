package com.bank.Bank.Management.System.Mapper;

import com.bank.Bank.Management.System.DTO.LoanDTO;
import com.bank.Bank.Management.System.Entity.Loan;

 public class LoanMapper {
    public static LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setAmount(loan.getAmount());
        dto.setStatus(loan.getStatus());
        dto.setCustomerId(loan.getCustomer().getId());
        return dto;
    }
}

