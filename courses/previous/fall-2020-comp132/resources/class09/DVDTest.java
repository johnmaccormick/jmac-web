

/**
 * The test class DVDTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DVDTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class DVDTest
     */
    public DVDTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    public void testConstructor()
    {
        DVD dVD3 = new DVD("Terminator 3", "R", 3);
        assertEquals("Terminator 3", dVD3.getTitle());
        assertEquals("R", dVD3.getRating());
        assertEquals(3, dVD3.getRentalLength());
        assertEquals(0, dVD3.getNightsRented());
    }

    public void testAddRentalNight()
    {
        DVD dVD1 = new DVD("Blazing Saddles", "R", 5);
        dVD1.addRentalNight();
        assertEquals(1, dVD1.getNightsRented());
        dVD1.addRentalNight();
        assertEquals(2, dVD1.getNightsRented());
    }

    public void testReturnDVD()
    {
        DVD dVD1 = new DVD("Caddy Shack", "R", 3);
        dVD1.addRentalNight();
        dVD1.addRentalNight();
        dVD1.returnDVD();
        assertEquals(0, dVD1.getNightsRented());
    }

    public void testIsOverdueNotOverdue()
    {
        DVD dVD1 = new DVD("Animal House", "R", 2);
        assertEquals(false, dVD1.isOverdue());
        dVD1.addRentalNight();
        assertEquals(false, dVD1.isOverdue());
        dVD1.addRentalNight();
        assertEquals(false, dVD1.isOverdue());
    }

    public void testIsOverdueIsOverdue()
    {
        DVD dVD1 = new DVD("Animal House", "R", 2);
        dVD1.addRentalNight();
        dVD1.addRentalNight();
        dVD1.addRentalNight();
        assertEquals(true, dVD1.isOverdue());
    }
    
    public void testToString()
    {
        DVD dVD1 = new DVD("Animal House", "R", 2);
        String str = "        Title: Animal House\n" +
                     "  MPAA Rating: R\n" +
                     "Rental Nights: 2\n" +
                     "   Nights Out: 0\n";
        assertEquals(str, dVD1.toString());
    }

	public void testSetLength()
	{
		DVD dVD1 = new DVD("Matrix", "R", 3);
		dVD1.setRentalLength(5);
		assertEquals(5, dVD1.getRentalLength());
	}
}
