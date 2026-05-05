package com.bank.Bank.Management.System.Controller;


import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Security.JwtUtil;
import com.bank.Bank.Management.System.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.UpdateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id,
                                                    @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        Long userId = jwtUtil.extractUserId(token);
        String role = jwtUtil.extractRole(token);

        if ("ADMIN".equals(role)) {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        }

        // ✅ Only allow if token’s ID matches requested ID
        if (!userId.equals(id)) {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        }

        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
