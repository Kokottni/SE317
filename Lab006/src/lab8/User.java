package lab8;

public class User {
    private String username;
    private String password;
    public CheckingAccount checkingAccount;
    public SavingsAccount savingsAccount;
    public UtilityCompany utilityCompany;

    public User(String username, String password, CheckingAccount checkingAccount, SavingsAccount savingsAccount, UtilityCompany utilityCompany) {
        this.username = username;
        this.password = password;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
        this.utilityCompany = utilityCompany;
    }

    // Method to log in to the user's account
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to check checking account balance
    public double checkCheckingBalance() {
        return checkingAccount.checkBalance();
    }

    // Method to check savings account balance
    public double checkSavingsBalance() {
        return savingsAccount.checkBalance();
    }

	public String getUsername() {
		return username;
	}

    // Getters and setters for other properties
}

