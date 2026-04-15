package com.bank.Bank.Management.System.Exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }
}
