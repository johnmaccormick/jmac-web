
/**
 * A class to calculate the weekly paycheck (with overtime) for an employee.
 * 
 * @author Tim Wahls
 */
public class Employee
{
    private String name; // employee name
    private double rate; // hourly pay rate of the employee
    private double standardHours; // the normal work week
    // the pay multiplier for overtime hours
    private double multiplier;
 
    /**
     * create an Employee object with name, pay rate, normal work hours and 
     * pay multiplier specified as parameters
     * @param initName the employee name
     * @param initRate the employee's hourly pay rate
     * @param initHours the number of hours in a normal work week
     * @param initMult the pay multiplier for overtime hours
     */
    public Employee(String initName, double initRate, double initHours,
                    double initMult)
    {
        name = initName;
        rate = initRate;
        standardHours = initHours;
        multiplier = initMult;
    }
    
    /** return the name of this employee
     *  @return the name of this employee
     */
    public String getName() {
        return name;
    }    
     
    /** return the hourly pay rate for this employee
     *  @return the hourly pay rate
     */
    public double getRate() {
        return rate;
    }
    
    /** return the number of hours in a standard work week for this employee
     *  @return the number of hours in the standard work week
     */
    public double getStandardHours() {
        return standardHours;
    }

    
    /** return the pay multiplier for overtime hours for this employee
     *  @return the pay multiplier for overtime hours 
     */
    public double getMultiplier() {
        return multiplier;
    }    
    
    /** increase the hourly pay rate of this employee by the specified amount
     * @param amt the amount to increase the pay rate by
     */
    public void giveRaise(double amt) {
        // add your code here
    }
    
    /** calculate the weekly pay for this employee based on the hours worked
     *  that week.  Instructions for this calculation are contained in the
     *  homework assignment.
     *  @param hours the hours worked for the week
     *  @return the pay amount for the week
     */
    public double calculateWeeklyPay(double hours) {
        // replace with your own code
        return 0;
    }
}
