package lab8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTests {

	private User user;

    @Before
    public void setUp() {
        // Create a user with sample accounts for testing
    	SavingsAccount savingsAccount = new SavingsAccount();
    	savingsAccount.balance = 500;
        CheckingAccount checkingAccount = new CheckingAccount(savingsAccount);
        checkingAccount.balance = 1000;
        UtilityCompany utilityCompany = new UtilityCompany();

        user = new User("testUser", "password123", checkingAccount, savingsAccount, utilityCompany);
    }
    
    @Test
    public void testLoginValidCredentials() {
        assertTrue(user.login("testUser", "password123"));
    }

    @Test
    public void testLoginInvalidUsername() {
        assertFalse(user.login("invalidUser", "password123"));
    }

    @Test
    public void testLoginInvalidPassword() {
        assertFalse(user.login("testUser", "wrongPassword"));
    }

    @Test
    public void testCheckCheckingBalance() {
        assertEquals(1000, user.checkCheckingBalance(), 0.0001);
    }

    @Test
    public void testCheckSavingsBalance() {
        assertEquals(500, user.checkSavingsBalance(), 0.0001);
    }
}
