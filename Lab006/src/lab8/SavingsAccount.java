package lab8;

public class SavingsAccount extends BankAccount {
    private static final double TRANSFER_LIMIT_PER_DAY = 100.0;

    public SavingsAccount() {
        super(0, 5000, 0);
    }

    // Method to transfer money from savings account to checking account
    public void transferToChecking(double amount) {
        // Check if amount is within daily transfer limit
        // Handle any other checks or exceptions
        if (amount > 0 && amount <= TRANSFER_LIMIT_PER_DAY && amount <= super.checkBalance()) {
            super.withdraw(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }

    // Override withdraw method to disallow withdrawals from savings account
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal from savings account is not allowed.");
    }

    // Override deposit method if needed for any specific functionality
    public void deposit(double amount) {
    	if(amount > super.dailyDepositLimit) {
    		System.out.println("Your deposit amount was too much, needs to be less than 5000");
    		return;
    	}
    	super.balance += amount;
    }
    // Getters and setters for other properties
}

