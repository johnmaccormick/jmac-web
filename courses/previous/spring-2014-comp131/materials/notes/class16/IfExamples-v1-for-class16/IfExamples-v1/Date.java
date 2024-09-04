
/**
 * Representing dates as day, month and year
 * 
 * @author Tim Wahls
 * @version 9/16/2005
 */
 
public class Date
{
	private int day; // the day of the month
	private String month; // should be "January", "February", ...
	private int year; 

	/**
	 * Create a date
	 * @param initMonth the month
	 * @param initDay the day
	 * @param initYear the year
	 */
	public Date(String initMonth, int initDay, int initYear)
	{
		day = initDay;
		month = initMonth;
		year = initYear;
	}
	
	/** 
	 * Return true if the month in this Date object has
	 * 30 days and false otherwise.
	 * @return if the month has 30 days.
	 */
	public boolean has30Days() {
	    return false;
	}

	/**
	 * print a date
	 */
	public void print()
	{
		System.out.println(month + " " + day + ", " + year);
	}
	
	/**
	 * return whether or not the date occurs in a leap year
	 * @return whether or not the date occurs in a leap year
	 */
	public boolean isLeap() {
       boolean leap;
        
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                leap = true;
            } else if (year % 100 == 0) {
                leap = false;
            } else {
                leap = true;
            }
        } else {
            leap = false;
        }
        
        return leap;
    }
}
