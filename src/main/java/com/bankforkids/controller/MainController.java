package com.bankforkids.controller;

import com.bankforkids.service.BankService;
import com.bankforkids.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import java.util.stream.Collectors;

import java.time.format.DateTimeFormatter;

public class MainController {
    @FXML private Label balanceLabel;
    @FXML private Label savingsLabel;
    @FXML private ListView<String> transactionListView;
    @FXML private VBox tasksContainer;
    @FXML private VBox goalsContainer;
    @FXML private TextField taskTitleField;
    @FXML private TextField taskRewardField;
    @FXML private TextField amountField;

    private BankService bankService;

    @FXML
    public void initialize() {
        // Simple default child for now, in a real app would be from login
        bankService = new BankService("Kid1");
        refreshUI();
    }

    private void refreshUI() {
        Child child = bankService.getChild();
        balanceLabel.setText(String.format("$%.2f", child.getCurrentAccount().getBalance()));
        savingsLabel.setText(String.format("$%.2f", child.getSavingsAccount().getBalance()));

        // Transactions
        transactionListView.setItems(FXCollections.observableArrayList(
            child.getCurrentAccount().getTransactions().stream()
                .map(t -> String.format("[%s] %s: $%.2f", 
                    t.getTimestamp().format(DateTimeFormatter.ofPattern("HH:mm")), 
                    t.getDescription(), t.getAmount()))
                .collect(java.util.stream.Collectors.toList())
        ));

        // Tasks
        tasksContainer.getChildren().clear();
        for (Task task : child.getTasks()) {
            HBox taskRow = new HBox(10);
            Label taskLbl = new Label(task.getTitle() + " ($" + task.getReward() + ")");
            Button btn = new Button(task.isCompleted() ? "Completed" : "Complete Task");
            btn.setDisable(task.isCompleted());
            btn.setOnAction(e -> {
                bankService.completeTask(task.getId());
                refreshUI();
            });
            taskRow.getChildren().addAll(taskLbl, btn);
            tasksContainer.getChildren().add(taskRow);
        }

        // Goals
        goalsContainer.getChildren().clear();
        for (Goal goal : child.getGoals()) {
            VBox goalBox = new VBox(5);
            ProgressBar pb = new ProgressBar(goal.getProgress());
            Label lbl = new Label(goal.getName() + " (" + (int)(goal.getProgress() * 100) + "%)");
            goalBox.getChildren().addAll(lbl, pb);
            goalsContainer.getChildren().add(goalBox);
        }
    }

    @FXML
    private void handleAddTask() {
        String title = taskTitleField.getText();
        double reward = Double.parseDouble(taskRewardField.getText());
        bankService.addTask(title, reward);
        taskTitleField.clear();
        taskRewardField.clear();
        refreshUI();
    }

    @FXML
    private void handleDeposit() {
        double amount = Double.parseDouble(amountField.getText());
        bankService.getChild().getCurrentAccount().deposit(amount, "Deposit");
        bankService.save();
        amountField.clear();
        refreshUI();
    }
}
