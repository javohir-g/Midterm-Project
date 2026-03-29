package com.bankforkids.model;

import java.io.Serializable;

public class Goal implements Serializable {
    private String name;
    private double targetAmount;
    private double savedAmount;

    public Goal(String name, double targetAmount) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.savedAmount = 0.0;
    }

    public String getName() { return name; }
    public double getTargetAmount() { return targetAmount; }
    public double getSavedAmount() { return savedAmount; }

    public void addSavings(double amount) {
        if (amount > 0) {
            savedAmount += amount;
        }
    }

    public double getProgress() {
        return Math.min(savedAmount / targetAmount, 1.0);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f/%.2f (%.0f%%)", name, savedAmount, targetAmount, getProgress() * 100);
    }
}
