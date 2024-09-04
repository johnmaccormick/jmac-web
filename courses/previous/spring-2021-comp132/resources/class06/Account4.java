
/**
 * simple representation of bank accounts
 * 
 * @author Tim Wahls, updated by John MacCormick
 * 
 */
public class Account4 {
	private int acctNumber; // account number
	private int balance; // in pennies
	private int interestRate; // in pct.

	/**
	 * Constructor for an Account with a specified account number and interest rate.
	 * 
	 * @param initAcctNumber   the account number.
	 * @param initInterestRate the interest rate.
	 */
	public Account4(int initAcctNumber, int initInterestRate) {
		acctNumber = initAcctNumber;
		balance = 0;
		interestRate = initInterestRate;
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
		if (withAmount <= balance) {
			balance = balance - withAmount;
		} else {
			System.out.println("withdrawal cancelled");
		}
		return;
	}

	public int computeInterest() {
		int interestAmount = balance * interestRate / 100;
		return interestAmount;
	}
	
	public void addInterest() {
		int interestAmount = computeInterest();
		balance = balance + interestAmount;
		return;
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
		int dollars = balance / 100;
		int cents = balance % 100;
		
		if(cents<10) {
			System.out.println("Balance is: $" + dollars + ".0" + cents);
		}
		else {
			System.out.println("Balance is: $" + dollars + "." + cents);
		}
	}

	public static void main(String[] args) {
		Account4 savingsAccount = new Account4(4402, 3);

		System.out.println("Depositing $50...");
		savingsAccount.deposit(5000);
		savingsAccount.print();

		System.out.println("Withdrawing $10...");
		savingsAccount.withdraw(1000);
		savingsAccount.print();

		System.out.println("Withdrawing $200...");
		savingsAccount.withdraw(20000);
		savingsAccount.print();
		
		System.out.println("Adding interest...");
		savingsAccount.addInterest();
		savingsAccount.print();
		
	}
}
