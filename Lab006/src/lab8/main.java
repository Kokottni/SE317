package lab8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        HashMap<String, Integer> userPathing = new HashMap<String, Integer>();
        int userCount = 0;
        // Simulate the user interaction
        while (true) {
            System.out.println("\nWelcome to the Utility Company System");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    if(userPathing.get(username) != null) {
                    	System.out.println("You need to choose a new username, this one is taken");
                    	break;
                    }
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    SavingsAccount save = new SavingsAccount();
                    CheckingAccount check = new CheckingAccount(save);
                    UtilityCompany util = new UtilityCompany();
                    User curr = new User(username, password, check, save, util);
                    users.add(curr);
                    userPathing.put(username, userCount);
                    ++userCount;
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    if (users.get(userPathing.get(loginUsername)).login(loginUsername, loginPassword)) {
                        System.out.println("Login successful.");
                        int use = userPathing.get(loginUsername);
                        User currentUser = users.get(use);
                        // After successful login, provide further options
                        while (true) {
                            System.out.println("\nUtility Company Menu");
                            System.out.println("1. Check Balance (Checking)");
                            System.out.println("2. Check Balance (Savings)");
                            System.out.println("3. Deposit (Chcecking)");
                            System.out.println("4. Deposit (Savings)");
                            System.out.println("5. Withdraw (Checking)");
                            System.out.println("6. Transfer (Checking -> Savings)");
                            System.out.println("7. Transfer (Savings -> Checking)");
                            System.out.println("8. Check Bill Payment History");
                            System.out.println("9. Check Next Bill Details");
                            System.out.println("10. Make Bill Payment");
                            System.out.println("11. Logout");
                            System.out.print("Enter your choice: ");
                            int userChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (userChoice) {
                            	case 1:
                            		System.out.println("Checking balance: " + currentUser.checkCheckingBalance());
                            		break;
                            	case 2:
                            		System.out.println("Savings balance: " + currentUser.checkSavingsBalance());
                            		break;
                            	case 3:
                            		System.out.println("Deposit amount: ");
                            		int depositAmount = scanner.nextInt();
                       		 		scanner.nextLine();
                       		 
                       		 		currentUser.checkingAccount.deposit(depositAmount);
                       		 		break;
                            	case 4:
                            		System.out.println("Deposite amount: ");
                            		int depositAmount2 = scanner.nextInt();
                       		 		scanner.nextLine();
                       		 
                       		 		currentUser.savingsAccount.deposit(depositAmount2);
                       		 		break;
                            	case 5:
                            		System.out.println("Checking balance: " + currentUser.checkCheckingBalance());
                            		System.out.println("Withdraw amount: ");
                        		 
                            		int withdrawAmount = scanner.nextInt();
                            		scanner.nextLine();
                        		 
                            		currentUser.checkingAccount.withdraw(withdrawAmount);
                        		 
                            		break;
                            	case 6:
                            		System.out.println("Checking balance: " + currentUser.checkCheckingBalance());
                            		System.out.println("Savings balance: " + currentUser.checkSavingsBalance());
                            		System.out.println("Transfer amount: ");
                        		
                            		int transferAmount = scanner.nextInt();
                       		 		scanner.nextLine();
                   
                       		 		currentUser.checkingAccount.transferToSavings(transferAmount);
                       		 		break;
                            	case 7:
                            		System.out.println("Checking balance: " + currentUser.checkCheckingBalance());
                            		System.out.println("Savings balance: " + currentUser.checkSavingsBalance());
                            		System.out.println("Transfer amount: ");
                        		
                            		int transferAmount2 = scanner.nextInt();
                       		 		scanner.nextLine();
                   
                       		 		currentUser.savingsAccount.transferToChecking(transferAmount2);
                       		 		break;
                            	case 8:
                            		currentUser.utilityCompany.checkBillPaymentHistory(loginUsername);
                            		break;
                            	case 9:
                            		currentUser.utilityCompany.checkNextBillDetails(loginUsername);
                            		break;
                            	case 10:
                            		System.out.print("Enter bill payment amount: ");
                            		double amount = scanner.nextDouble();
                            		currentUser.utilityCompany.makeBillPayment(loginUsername, amount);
                            		break;
                            	case 11:
                            		System.out.println("Logging out...");
                            		break;
                            	default:
                            		System.out.println("Invalid choice. Please try again.");
                            }

                            if (userChoice == 11) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Utility Company System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
