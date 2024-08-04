package lab8;

public class BankAccount {
    public double balance;
    public double dailyDepositLimit;
    public double dailyWithdrawalLimit;

    public BankAccount(double balance, double dailyDepositLimit, double dailyWithdrawalLimit) {
        this.balance = balance;
        this.dailyDepositLimit = dailyDepositLimit;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        // Check if daily deposit limit is exceeded
        // Handle any other checks or exceptions
        balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        // Check if daily withdrawal limit is exceeded
        // Handle insufficient balance or other checks
        balance -= amount;
    }

    // Method to check the balance of the account
    public double checkBalance() {
        return balance;
    }

    // Getters and setters for other properties
}

