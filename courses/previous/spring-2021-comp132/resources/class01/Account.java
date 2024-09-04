
/**
 * simple representation of bank accounts
 * 
 * @author Tim Wahls
 *
 */
public class Account {
	private int acctNumber; // account number
	private int balance; // in pennies
	private int interestRate; // in pennies

	/**
	 * Constructor for creating an Account object with default values for
	 * the fields.
	 */
	public Account() {
		balance = 0;
		acctNumber = 0;
		interestRate = 0;
	}

	/**
	 * Constructor for objects of class Account
	 * 
	 * @param initAcctNumber the new account number
	 */
	public Account(int initAcctNumber) {
		// initialize instance variables
		acctNumber = initAcctNumber;
		balance = 0;
		interestRate = 0;
	}

	public Account(int balance, int interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}

	/**
	 * set the account number
	 * 
	 * @param acct the new account number
	 */
	public void setAccountNumber(int acct) {
		acctNumber = acct;
	}

	/**
	 * get the account number
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return acctNumber;
	}

	/**
	 * deposit money into the account
	 * 
	 * @param depAmount the amount to deposit
	 */
	public void deposit(int depAmount) {
		balance = balance + depAmount;
	}

	/**
	 * withdraw money from the account
	 * 
	 * @param withAmount the amount to withdraw
	 */
	public void withdraw(int withAmount) {
		balance = balance - withAmount;
	}

	/**
	 * check the account balance (an accessor method)
	 * 
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

	public static void main(String[] args) {
		// Create a new Account object with a balance of $50 (5000 cents)
		// and interest rate of 12%
		Account account = new Account(5000, 12);
		// Withdraw two dollars from the account
		account.withdraw(200);
		// Get the new balance and store it in a local variable
		int newBalance = account.getBalance();
		// Print out the new balance
		System.out.println("New balance is " + newBalance);
	}

}
