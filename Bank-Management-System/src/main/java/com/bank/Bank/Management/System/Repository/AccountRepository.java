package com.bank.Bank.Management.System.Repository;

import com.bank.Bank.Management.System.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCustomerId(Long customerId);

    Account findByAccountNumber(String accountNumber);
}
