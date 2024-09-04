

/**
 * The test class FindMaxTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FindMaxTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class FindMaxTest
     */
    public FindMaxTest()
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

    public void testMax1()
    {
        FindMax findMax1 = new FindMax(4, 3, 2);
        assertEquals(4, findMax1.max3());
    }

    public void testMax2()
    {
        FindMax findMax1 = new FindMax(5, 3, 4);
        assertEquals(5, findMax1.max3());
    }
    
    public void testMax3()
    {
        FindMax findMax1 = new FindMax(2, 4, 3);
        assertEquals(4, findMax1.max3());
    }
    
    public void testMax4()
    {
        FindMax findMax1 = new FindMax(4, 5, 6);
        assertEquals(6, findMax1.max3());
    }
}




