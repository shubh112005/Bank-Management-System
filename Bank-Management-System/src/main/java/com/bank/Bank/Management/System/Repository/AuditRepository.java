package com.bank.Bank.Management.System.Repository;

import com.bank.Bank.Management.System.Entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {

    List<Audit> findByLoanId(Long loanId);
    List<Audit> findByPerformedBy(String performedBy);
}
