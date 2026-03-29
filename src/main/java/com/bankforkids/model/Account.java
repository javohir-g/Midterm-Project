package com.bankforkids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Serializable {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return transactions; }

    public void deposit(double amount, String description) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(description, amount, "DEPOSIT"));
        }
    }

    public boolean withdraw(double amount, String description) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(description, amount, "WITHDRAW"));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" + "number='" + accountNumber + '\'' + ", balance=" + balance + '}';
    }
}
