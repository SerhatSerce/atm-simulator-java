package com.serhat.atm.service;

import com.serhat.atm.model.Account;

import java.util.List;

public class AuthService {

    public Account login(List<Account> accounts, String girilenPin) {

        for (Account acc : accounts) {
            if (acc.getPin().equals(girilenPin)) {
                return acc;
            }
        }

        return null;
    }
}