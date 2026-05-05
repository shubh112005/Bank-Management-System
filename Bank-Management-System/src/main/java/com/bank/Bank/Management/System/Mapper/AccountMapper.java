package com.bank.Bank.Management.System.Mapper;

import com.bank.Bank.Management.System.DTO.AccountDTO;
import com.bank.Bank.Management.System.Entity.Account;

public class AccountMapper {

    public static AccountDTO toDTO(Account account){

        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setType(account.getType());
        dto.setBalance(account.getBalance());
        dto.setCustomerId(account.getCustomer().getId());
        return dto;
    }
}
