package lab8;

public class CheckingAccount extends BankAccount {
    private SavingsAccount savingsAccount;

    public CheckingAccount(SavingsAccount savingsAccount) {
        super(0, 5000, 500);
        this.savingsAccount = savingsAccount;
    }

    // Method to transfer money from checking account to savings account
    public void transferToSavings(double amount) {
        // Check if amount is within daily limits
        // Handle any other checks or exceptions
        if (amount > 0 && amount <= super.checkBalance()) {
            super.withdraw(amount);
            savingsAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }

    // Method to pay bill
    public void payBill(double amount) {
        // Check if amount is within daily limits
        // Handle any other checks or exceptions
        if (amount > 0 && amount <= super.checkBalance()) {
            super.withdraw(amount);
            System.out.println("Bill payment successful.");
        } else {
            System.out.println("Bill payment failed. Insufficient funds or invalid amount.");
        }
    }

    // Override withdraw method to include overdraft protection
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= super.dailyWithdrawalLimit) {
            super.withdraw(amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
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

