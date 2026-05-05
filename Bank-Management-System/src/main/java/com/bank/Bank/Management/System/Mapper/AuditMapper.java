package com.bank.Bank.Management.System.Mapper;

import com.bank.Bank.Management.System.DTO.AuditDTO;
import com.bank.Bank.Management.System.Entity.Audit;

public class AuditMapper {
    public static AuditDTO toDTO(Audit audit) {
        AuditDTO dto = new AuditDTO();
        dto.setId(audit.getId());
        dto.setAction(audit.getAction());
        dto.setPerformedBy(audit.getPerformedBy());
        dto.setTimestamp(audit.getTimestamp());
        dto.setLoanId(audit.getLoanId());
        return dto;
    }
}
