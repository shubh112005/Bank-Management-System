package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Data
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy="customer", cascade= CascadeType.ALL)
    private List<Account> account;


}
