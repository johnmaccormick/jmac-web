
/**
 * simple representation of bank accounts
 * 
 * @author Tim Wahls
 *
 */
public class Account
{
    private int acctNumber; // account number
    private int balance; // in pennies

    /**
     * Constructor for creating an Account object with
     * default values for the fields.
     */
    public Account() {
        balance = 0;
        acctNumber = 0;
    }
    
    /**
     * Constructor for objects of class Account
     * @param initAcctNumber the new account number
     */
    public Account(int initAcctNumber)
    {
        // initialize instance variables
        acctNumber = initAcctNumber;
        balance = 0;
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
        System.out.println("Balance is: " + balance + " cents.");
    }
    
}
