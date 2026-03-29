package com.bankforkids;

import com.bankforkids.service.BankService;
import com.bankforkids.model.Child;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankServiceTest {
    private BankService bankService;

    @Before
    public void setUp() {
        // Use a test child name
        bankService = new BankService("TestKid");
    }

    @Test
    public void testInitialBalance() {
        Child child = bankService.getChild();
        assertEquals(0.0, child.getCurrentAccount().getBalance(), 0.001);
        assertEquals(0.0, child.getSavingsAccount().getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        bankService.getChild().getCurrentAccount().deposit(100.0, "Test Deposit");
        assertEquals(100.0, bankService.getChild().getCurrentAccount().getBalance(), 0.001);
    }

    @Test
    public void testTaskCompletion() {
        bankService.addTask("Clean Room", 50.0);
        String taskId = bankService.getChild().getTasks().get(0).getId();
        bankService.completeTask(taskId);
        
        assertTrue(bankService.getChild().getTasks().get(0).isCompleted());
        assertEquals(50.0, bankService.getChild().getCurrentAccount().getBalance(), 0.001);
    }

    @Test
    public void testSavingGoal() {
        bankService.createGoal("New Bike", 500.0);
        bankService.getChild().getCurrentAccount().deposit(200.0, "Lucky Money");
        bankService.saveToGoal("New Bike", 150.0);
        
        assertEquals(50.0, bankService.getChild().getCurrentAccount().getBalance(), 0.001);
        assertEquals(150.0, bankService.getChild().getGoals().get(0).getSavedAmount(), 0.001);
    }
}
