package com.bank.Bank.Management.System.Services;

import com.bank.Bank.Management.System.Entity.Customer;
import com.bank.Bank.Management.System.Exception.CustomerNotFoundException;
import com.bank.Bank.Management.System.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
            return customerRepository.findById(id).
                    orElseThrow(() -> new CustomerNotFoundException("Customer with ID" + id +"not found."));
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer UpdateCustomer(Long id, Customer updateCustomer){
        Customer customer= getCustomerById(id);
        customer.setName(updateCustomer.getName());
        customer.setEmail(updateCustomer.getEmail());
        customer.setPhone(updateCustomer.getPhone());
        customer.setAddress(updateCustomer.getAddress());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }


}
