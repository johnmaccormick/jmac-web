
/**
 * simple representation of bank accounts
 * 
 * @author Tim Wahls
 * @date 6/26/2005
 */
public class Account
{
    private int acctNumber; // account number
    private int balance; // in pennies
    private int interestRate; // in pct.
    
    /**
     * Constructor for creating an Account object with
     * default values for the fields.
     */
    public Account() {
        balance = 0;
        acctNumber = 0;
        interestRate = 2;
    }
    
    /**
     * Constructor for objects of class Account
     * @param initAcctNumber the new account number
     */
    public Account(int initAcctNumber)
    {
        // initialise instance variables
        acctNumber = initAcctNumber;
        balance = 0;
        interestRate = 0;
    }
    
    /**
     * Constructor for an Account with a specified
     * account number and interest rate.
     * @param initAcctNumber the account number.
     * @param initInterestRate the interest rate.
     */
    public Account(int initAcctNumber, int initInterestRate) {
        acctNumber = initAcctNumber;
        balance = 0;
        interestRate = initInterestRate;
    }
    
    /**
     * set the account number
     * @param acct the new account number
     */
    public void setAccountNumber(int acct)
    {
        acctNumber = acct;
    }
    
    /**
     * get the account number
     * @return the account number
     */
    public int getAccountNumber() {
        return acctNumber;
    }
    
    /**
     *  deposit money into the account
     *  @param depAmount the amount to deposit
     */
    public void deposit(int depAmount) {
        balance = balance + depAmount;
    }
    
    /** 
     * withdraw money from the account
     * @param withAmount the amount to withdraw
     */
    public void withdraw(int withAmount) {
         balance = balance - withAmount;
    } 

    /** 
     * check the account balance (an accessor method)
     * @return the account balance
     */
    public int getBalance() {
        return balance;
    }
    
    /**
     * display the account number and balance on the screen
     */
    public void print() {
 
      System.out.println("Account number: " + acctNumber);
      /*
      System.out.println("Balance is: $" + (balance / 100) + "." + 
                         (balance % 100));
      */
                        
    
      System.out.println("Balance is: $" + (balance / 100) + "." + 
          (balance % 100) / 10 + "" + (balance % 100) % 10 + ".");
                        
    }
    
    public static void main(String[] args)
    {
    	Account account = new Account();
    	
    	for (String arg: args) {
    		int val;
    		try {
				val = Integer.parseInt(arg);
				account.deposit(val);
	    		System.out.println("Deposited " + val + " cents.");
			} catch (NumberFormatException e) {
				System.out.println("Ignoring unexpected deposit value " + arg);
			}
    	}
    	
    	
    	System.out.println("Final balance is " + account.getBalance() + " cents.");
    }
}
