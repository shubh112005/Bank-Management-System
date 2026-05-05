package com.bank.Bank.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;
}