package Bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankCustomerTest {

	Account checking;
	Account savings;
	BankCustomer customer;
	BankCustomer checkingOnly;

	@Before
	public void setUp() throws Exception {
		checking = new Account(123);
		savings = new Account(456);
		customer = new BankCustomer("Ito", "Tokyo", "+1-61-434", checking, savings);
		checkingOnly = new BankCustomer("Ito", "Tokyo", "+1-61-434", checking, null);
	}

	@Test
	public void testBankCustomer() {
		assertEquals("Ito", customer.getName());
		assertEquals("Tokyo", customer.getAddress());
		assertEquals("+1-61-434", customer.getPhoneNumber());
		assertEquals(0, customer.getTotalBalance());
	}

	@Test
	public void testGetTotalBalance() {
		customer.depositChecking(5);
		customer.depositSavings(7);
		assertEquals(12, customer.getTotalBalance());
	}

	@Test
	public void testSavingsToChecking() {
		customer.depositChecking(5);
		customer.depositSavings(7);
		customer.savingsToChecking(3);
		// Ideally, we would check the individual balances, but The BankCustomer class
		// does not provide the accessor methods we need to do that. Therefore, we just
		// check the total balance here.
		assertEquals(12, customer.getTotalBalance());
	}

}
