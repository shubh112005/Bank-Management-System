package com.bank.Bank.Management.System.Exception;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message){
        super(message);
    }
}
