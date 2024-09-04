import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CandidateTest {

	@Test
	public void testConstructor() {
		Candidate c1 = new Candidate("Bob", "Democrat", 100);

		assertEquals("Bob", c1.getName());
		assertEquals("Democrat", c1.getParty());
		assertEquals(100, c1.getVotes());
	}

	@Test
	public void testSetParty() {
		Candidate c1 = new Candidate("Bob", "Democrat", 100);
		assertEquals("Democrat", c1.getParty());
		c1.setParty("Republican");
		assertEquals("Republican", c1.getParty());
	}

}
