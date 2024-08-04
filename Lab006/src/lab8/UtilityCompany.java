package lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UtilityCompany {
    private Map<String, String> userAccounts; // Map of username to account number
    private Map<String, List<Double>> billPayments; // Map of account number to last 3 bill payments
    private Map<String, Double> checkingBalances; // Map of account number to checking balance
    private Map<String, Double> savingBalances; // Map of account number to saving balance
    private double nextBillAmount;
    private String nextBillDueDate;

    public UtilityCompany() {
        this.userAccounts = new HashMap<>();
        this.billPayments = new HashMap<>();
        this.checkingBalances = new HashMap<>();
        this.savingBalances = new HashMap<>();
        this.nextBillAmount = 50;
        this.nextBillDueDate = "29 days from now";
    }

    // Method to create a new account at the utility company
    public void createAccount(String username, String password) {
        // Generate a new account number (6-digit) automatically
        String accountNumber = generateAccountNumber();
        userAccounts.put(username, accountNumber);
        checkingBalances.put(accountNumber, 0.0);
        savingBalances.put(accountNumber, 0.0);
        System.out.println("Account created successfully. Your account number is: " + accountNumber);
    }

    // Method to generate a new account number
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return accountNumber.toString();
    }

    // Method to log in to the user's utility account
    public boolean login(String username, String password) {
        return userAccounts.containsKey(username) && userAccounts.get(username).equals(password);
    }

    // Method to check bill payment history
    public void checkBillPaymentHistory(String username) {
        // Retrieve and display the last 3 bill payments for the user
        String accountNumber = userAccounts.get(username);
        if (billPayments.containsKey(accountNumber)) {
            List<Double> payments = billPayments.get(accountNumber);
            System.out.println("Bill Payment History for Account Number: " + accountNumber);
            for (Double payment : payments) {
                System.out.println(payment);
            }
        } else {
            System.out.println("No bill payment history found for this account.");
        }
    }

    // Method to check next bill payment amount and due date
    public void checkNextBillDetails(String username) {
        // Retrieve and display the next bill payment amount and due date for the user
        String accountNumber = userAccounts.get(username);
        System.out.println("Next Bill Payment Details for Account Number: " + accountNumber);
        System.out.println("Amount: " + nextBillAmount);
        System.out.println("Due Date: " + nextBillDueDate);
    }

    // Method to make a bill payment
    public void makeBillPayment(String username, double amount) {
        // Add the bill payment to the user's account and update next bill details
        String accountNumber = userAccounts.get(username);
        if (billPayments.containsKey(accountNumber)) {
            List<Double> payments = billPayments.get(accountNumber);
            payments.add(amount);
            billPayments.put(accountNumber, payments);
        } else {
            List<Double> payments = new ArrayList<>();
            payments.add(amount);
            billPayments.put(accountNumber, payments);
        }
        System.out.println("Bill payment of $" + amount + " made successfully.");
    }

    // Getters and setters for other properties
    /**
     * Gets the bill payments.
     *
     * @return the bill payments
     */
    public Map<String, List<Double>> getBillPayments() {
        return billPayments;
    }

    /**
     * Gets the user accounts.
     *
     * @return the user accounts
     */
    public Map<String, String> getUserAccounts() {
        return userAccounts;
    }
}
