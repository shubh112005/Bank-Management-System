package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;          // e.g. "LOAN_APPROVED", "LOAN_REJECTED"
    private String performedBy;     // admin username
    private LocalDateTime timestamp;

    private Long loanId;            // which loan was affected


    public Audit() {}

    public Audit(String action, String performedBy, Long loanId) {
        this.action = action;
        this.performedBy = performedBy;
        this.loanId = loanId;
        this.timestamp = LocalDateTime.now();
    }

    // --- Static factory method for cleaner code ---
    public static Audit create(String action, String performedBy, Long loanId) {
        return new Audit(action, performedBy, loanId);
    }
}
