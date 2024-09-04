import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoStoreTest {

	DVD dvd1;
	DVD dvd2;
	DVD dvd3;
	VideoStore store;

	@Before
	public void setUp() throws Exception {
		dvd1 = new DVD("Fantastic Mr. Fox", "PG", 7);
		dvd2 = new DVD("Isle of Dogs", "PG-13", 7);
		dvd3 = new DVD("Avengers: Infinity War", "PG-13", 2);
		store = new VideoStore("COMP132 Movies");

		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
	}

	@Test
	public void testVideoStore() {
		assertEquals("COMP132 Movies", store.getStoreName());
	}

	@Test
	public void testGetNumDVDs() {
		assertEquals(3, store.getNumDVDs());
	}

//	@Test
//	public void testAddDVD() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveDVD() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetDVD() {
//		fail("Not yet implemented");
//	}

}
