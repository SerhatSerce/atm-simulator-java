package com.serhat.atm.repository;

import com.serhat.atm.model.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private List<Account> accounts;

    public AccountRepository() {
        accounts = new ArrayList<>();

        // başlangıç verileri
        accounts.add(new Account("1111", 1000));
        accounts.add(new Account("2222", 500));
        accounts.add(new Account("3333", 2000));
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}