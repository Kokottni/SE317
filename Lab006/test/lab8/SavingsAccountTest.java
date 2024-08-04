package lab8;

import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest {

    @Test
    public void testTransferToChecking_SuccessfulTransfer() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(2000);
        savingsAccount.transferToChecking(100);
        assertEquals(1900, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void testTransferToChecking_InvalidAmount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(2000);
        savingsAccount.transferToChecking(3000);
        assertEquals(2000, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void testTransferToChecking_InsufficientFunds() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(100);
        savingsAccount.transferToChecking(200);
        assertEquals(100, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void testWithdraw_Disallowed() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        assertEquals(1000, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void testDeposit_ExceedsDailyLimit() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(6000);
        assertEquals(0, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void testDeposit_ValidAmount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(2000);
        assertEquals(2000, savingsAccount.checkBalance(), 0.001);
    }
}
