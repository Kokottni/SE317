package lab8;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class UtilityCompanyTest {
    private UtilityCompany utilityCompany;

    @Before
    public void setUp() {
        utilityCompany = new UtilityCompany();
    }

    @Test
    public void testLoginInvalid() {
        assertFalse(utilityCompany.login("invalidUser", "invalidPassword"));
    }

    @Test
    public void testCheckBillPaymentHistory() {
        String username = "testUser";
        utilityCompany.createAccount(username, "testPassword");
        utilityCompany.makeBillPayment(username, 100.0);
        utilityCompany.makeBillPayment(username, 150.0);
        utilityCompany.makeBillPayment(username, 200.0);
        utilityCompany.checkBillPaymentHistory(username);
    }

    @Test
    public void testCheckNextBillDetails() {
        String username = "testUser";
        utilityCompany.createAccount(username, "testPassword");
        utilityCompany.checkNextBillDetails(username);
    }

    @Test
    public void testMakeBillPayment() {
        String username = "testUser";
        utilityCompany.createAccount(username, "testPassword");
        utilityCompany.makeBillPayment(username, 100.0);
        Map<String, List<Double>> billPayments = utilityCompany.getBillPayments();
        assertTrue(billPayments.containsKey(utilityCompany.getUserAccounts().get(username)));
        assertEquals(100.0, billPayments.get(utilityCompany.getUserAccounts().get(username)).get(0), 0.001);
    }

    // Additional tests for data storage, etc. can be added as per requirements
}
