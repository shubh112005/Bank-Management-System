package com.bank.Bank.Management.System.Repository;

import com.bank.Bank.Management.System.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
}
