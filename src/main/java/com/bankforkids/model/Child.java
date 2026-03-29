package com.bankforkids.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Child implements Serializable {
    private String name;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;
    private List<Task> tasks;
    private List<Goal> goals;

    public Child(String name) {
        this.name = name;
        this.currentAccount = new CurrentAccount("CUR" + System.currentTimeMillis());
        this.savingsAccount = new SavingsAccount("SAV" + System.currentTimeMillis());
        this.tasks = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    public String getName() { return name; }
    public CurrentAccount getCurrentAccount() { return currentAccount; }
    public SavingsAccount getSavingsAccount() { return savingsAccount; }
    public List<Task> getTasks() { return tasks; }
    public List<Goal> getGoals() { return goals; }
}
