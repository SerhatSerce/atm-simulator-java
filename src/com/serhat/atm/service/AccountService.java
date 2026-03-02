package com.serhat.atm.service;

import com.serhat.atm.model.Account;

public class AccountService {

    public boolean deposit(Account account, double amount) {
        return account.deposit(amount);
    }

    public boolean withdraw(Account account, double amount) {
        return account.withdraw(amount);
    }
}