import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeTest {

	@Test
	public void testDrink() {
		Coffee coffee = new Coffee();

		try {
			coffee.drink("nice and strong");
		} catch (CoffeeException e) {
			fail("Strong coffee threw an exception");
		}

		boolean caughtException = false;
		try {
			coffee.drink("subtle");
		} catch (CoffeeException e) {
			caughtException = true;
		}
		assertTrue("Failed to catch CoffeeException", caughtException);
	}

}
