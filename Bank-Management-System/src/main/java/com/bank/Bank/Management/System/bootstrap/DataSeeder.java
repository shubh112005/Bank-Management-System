package com.bank.Bank.Management.System.bootstrap;

import com.bank.Bank.Management.System.Entity.Account;
import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Entity.Loan;
import com.bank.Bank.Management.System.Entity.User;
import com.bank.Bank.Management.System.Repository.AccountRepository;
import com.bank.Bank.Management.System.Repository.CustomerRepository;
import com.bank.Bank.Management.System.Repository.LoanRepository;
import com.bank.Bank.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private AccountRepository accountRepository;
    @Autowired private LoanRepository loanRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Seed Admin if not exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }

        // Seed Customers
        if (customerRepository.count() == 0) {
            User user1 = new User();
            user1.setUsername("john");
            user1.setPassword(passwordEncoder.encode("john123"));
            user1.setRole("CUSTOMER");
            userRepository.save(user1);

            Customer customer1 = new Customer();
            customer1.setName("John Doe");
            customer1.setEmail("john@example.com");
            customer1.setUser(user1);
            customerRepository.save(customer1);

            Account account1 = new Account();
            account1.setType("SAVINGS");
            account1.setBalance(5000.0);
            account1.setCustomer(customer1);
            accountRepository.save(account1);

            Loan loan1 = new Loan();
            loan1.setAmount(10000.0);
            loan1.setStatus("PENDING");
            loan1.setCustomer(customer1);
            loanRepository.save(loan1);

            // Add another customer for variety
            User user2 = new User();
            user2.setUsername("alice");
            user2.setPassword(passwordEncoder.encode("alice123"));
            user2.setRole("CUSTOMER");
            userRepository.save(user2);

            Customer customer2 = new Customer();
            customer2.setName("Alice Smith");
            customer2.setEmail("alice@example.com");
            customer2.setUser(user2);
            customerRepository.save(customer2);

            Account account2 = new Account();
            account2.setType("CURRENT");
            account2.setBalance(12000.0);
            account2.setCustomer(customer2);
            accountRepository.save(account2);
        }
    }
}
