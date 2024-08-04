package lab8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    @Before
    public void setUp() {
        savingsAccount = new SavingsAccount();
        checkingAccount = new CheckingAccount(savingsAccount);
    }

    @Test
    public void testTransferToSavings_ValidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double initialSavingsBalance = savingsAccount.checkBalance();
        double transferAmount = 1000;

        checkingAccount.transferToSavings(transferAmount);

        assertEquals("Checking account balance should decrease after transfer", 
                     0, 
                     checkingAccount.checkBalance(), 
                     0);
        assertEquals("Savings account balance should increase after transfer", 
                     0, 
                     savingsAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testTransferToSavings_InvalidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double initialSavingsBalance = savingsAccount.checkBalance();
        double transferAmount = 6000; // more than daily limit

        checkingAccount.transferToSavings(transferAmount);

        assertEquals("Checking account balance should remain unchanged after failed transfer", 
                     initialCheckingBalance, 
                     checkingAccount.checkBalance(), 
                     0);
        assertEquals("Savings account balance should remain unchanged after failed transfer", 
                     initialSavingsBalance, 
                     savingsAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testPayBill_ValidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double billAmount = 2000;

        checkingAccount.payBill(billAmount);

        assertEquals("Checking account balance should decrease after bill payment", 
                     0, 
                     checkingAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testPayBill_InvalidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double billAmount = 6000; // more than daily limit

        checkingAccount.payBill(billAmount);

        assertEquals("Checking account balance should remain unchanged after failed bill payment", 
                     initialCheckingBalance, 
                     checkingAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testWithdraw_ValidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double withdrawAmount = 2000;

        checkingAccount.withdraw(withdrawAmount);

        assertEquals("Checking account balance should decrease after withdrawal", 
                     0, 
                     checkingAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testWithdraw_InvalidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double withdrawAmount = 6000; // more than daily limit

        checkingAccount.withdraw(withdrawAmount);

        assertEquals("Checking account balance should remain unchanged after failed withdrawal", 
                     initialCheckingBalance, 
                     checkingAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testDeposit_ValidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double depositAmount = 2000;

        checkingAccount.deposit(depositAmount);

        assertEquals("Checking account balance should increase after deposit", 
                     initialCheckingBalance + depositAmount, 
                     checkingAccount.checkBalance(), 
                     0);
    }

    @Test
    public void testDeposit_InvalidAmount() {
        double initialCheckingBalance = checkingAccount.checkBalance();
        double depositAmount = 6000; // more than daily deposit limit

        checkingAccount.deposit(depositAmount);

        assertEquals("Checking account balance should remain unchanged after failed deposit", 
                     initialCheckingBalance, 
                     checkingAccount.checkBalance(), 
                     0);
    }
}
