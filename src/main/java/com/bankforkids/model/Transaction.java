package com.bankforkids.model;

import java.time.LocalDateTime;
import java.io.Serializable;

public class Transaction implements Serializable {
    private LocalDateTime timestamp;
    private String description;
    private double amount;
    private String type; // DEPOSIT, WITHDRAW, TASK_REWARD

    public Transaction(String description, double amount, String type) {
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f (%s)", timestamp, type, amount, description);
    }
}
