package com.bankforkids.service;

import com.bankforkids.model.*;
import java.util.*;

public class BankService {
    private Child child;
    private final PersistenceService persistenceService;

    public BankService(String childName) {
        this.persistenceService = new PersistenceService();
        this.child = persistenceService.loadChild(childName);
        if (this.child == null) {
            this.child = new Child(childName);
            save();
        }
    }

    public Child getChild() { return child; }

    public void addTask(String title, double reward) {
        Task task = new Task("T" + System.currentTimeMillis(), title, reward);
        child.getTasks().add(task);
        save();
    }

    public void completeTask(String taskId) {
        for (Task t : child.getTasks()) {
            if (t.getId().equals(taskId) && !t.isCompleted()) {
                t.setCompleted(true);
                child.getCurrentAccount().deposit(t.getReward(), "Reward for: " + t.getTitle());
                save();
                break;
            }
        }
    }

    public void createGoal(String name, double target) {
        child.getGoals().add(new Goal(name, target));
        save();
    }

    public void saveToGoal(String goalName, double amount) {
        for (Goal g : child.getGoals()) {
            if (g.getName().equals(goalName)) {
                if (child.getCurrentAccount().withdraw(amount, "Saving for goal: " + goalName)) {
                    g.addSavings(amount);
                    save();
                }
                break;
            }
        }
    }

    public void save() {
        persistenceService.saveChild(child);
    }
}
