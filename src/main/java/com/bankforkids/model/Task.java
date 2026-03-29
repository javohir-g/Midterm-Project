package com.bankforkids.model;

import java.io.Serializable;

public class Task implements Serializable {
    private String id;
    private String title;
    private double reward;
    private boolean completed;

    public Task(String id, String title, double reward) {
        this.id = id;
        this.title = title;
        this.reward = reward;
        this.completed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public double getReward() { return reward; }
    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return title + " - Reward: " + reward + (completed ? " [Completed]" : " [Pending]");
    }
}
