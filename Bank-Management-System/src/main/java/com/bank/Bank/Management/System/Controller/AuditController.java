package com.bank.Bank.Management.System.Controller;

import com.bank.Bank.Management.System.DTO.AuditDTO;
import com.bank.Bank.Management.System.Entity.Audit;
import com.bank.Bank.Management.System.Mapper.AuditMapper;
import com.bank.Bank.Management.System.Repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditRepository auditRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        List<AuditDTO> dtos = auditRepository.findAll()
                .stream().map(AuditMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/loan/{loanId}")
    public ResponseEntity<List<AuditDTO>> getAuditsByLoan(@PathVariable Long loanId) {
        List<AuditDTO> dtos = auditRepository.findByLoanId(loanId)
                .stream().map(AuditMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/{username}")
    public ResponseEntity<List<AuditDTO>> getAuditsByAdmin(@PathVariable String username) {
        List<AuditDTO> dtos = auditRepository.findByPerformedBy(username)
                .stream().map(AuditMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }
}
