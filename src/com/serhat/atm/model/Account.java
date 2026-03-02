package com.serhat.atm.model;

public class Account {

    private String pin;
    private double balance;

    public Account(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}