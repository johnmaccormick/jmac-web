/**
 * simple representation of bank accounts
 * 
 * @author Tim Wahls, updated by John MacCormick
 * 
 */
public class Account6 {
	private int acctNumber; // account number
	private int balance; // in pennies
	private int interestRate; // in pct.

	/**
	 * Constructor for an Account with a specified account number and interest rate.
	 * 
	 * @param initAcctNumber   the account number.
	 * @param initInterestRate the interest rate.
	 */
	public Account6(int initAcctNumber, int initInterestRate) {
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

	public int computeQuarterlyInterest() {
		int interestAmount = interestRate / 100 * balance / 4;
		return interestAmount;
	}

	public void addInterest() {
		int interestAmount = interestRate / 100 * balance;
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

	public void printDollarBalance() {
		int dollars = balance / 100;
		System.out.println("Dollar balance is " + dollars);
	}

	/**
	 * display the account number and balance on the screen
	 */
	public void print() {
		int dollars = balance / 100;
		int cents = balance % 100;
		String balanceStr = "$";
		if (cents < 10) {
			balanceStr = balanceStr + dollars + ".0" + cents;
		} else {
			balanceStr = balanceStr + dollars + "." + cents;
		}
		System.out.println("acctNumber=" + acctNumber + ", balance=" + balanceStr + ", interestRate=" + interestRate);
	}

	public boolean equals(Account6 other) {
		if (acctNumber != other.acctNumber)
			return false;
		if (balance != other.balance)
			return false;
		if (interestRate != other.interestRate)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Account6 accountA = new Account6(4402, 3);
		Account6 accountB = new Account6(4402, 3);
		Account6 accountC = accountA;

		System.out.print("accountA: ");
		accountA.print();
		System.out.print("accountB: ");
		accountB.print();
		System.out.print("accountC: ");
		accountC.print();

		System.out.println();
		System.out.println("accountA == accountB:      " + (accountA == accountB));
		System.out.println("accountA.equals(accountB): " + accountA.equals(accountB));
		System.out.println("accountA == accountC:      " + (accountA == accountC));
	}
}
