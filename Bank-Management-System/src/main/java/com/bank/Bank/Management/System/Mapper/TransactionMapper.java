package com.bank.Bank.Management.System.Mapper;

import com.bank.Bank.Management.System.DTO.TransactionDTO;
import com.bank.Bank.Management.System.Entity.Transaction;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setType(transaction.getType());
        dto.setAmount(transaction.getAmount());
        dto.setTimestamp(transaction.getTimestamp());
        dto.setAccountId(transaction.getAccount().getId());
        dto.setTargetAccountId(transaction.getTargetAccountId());
        return dto;
    }
}
