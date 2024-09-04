/**
 * Class representing a PhoneNumber. This class parses values from a String of
 * the form "(###) ###-####" to find the area code, exchange and number
 * information for a standard US phone number.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class PhoneNumber {

	private int areaCode;
	private int exchange;
	private int number;

	public PhoneNumber(String phNumber) {
		areaCode = parseAreaCode(phNumber);
		exchange = parseExchange(phNumber);
		number = parseNumber(phNumber);
	}

	private int parseAreaCode(String phNumber) {
		String acStr = phNumber.substring(1, 4);
		int acInt = Integer.parseInt(acStr);
		return acInt;
	}

	private int parseExchange(String phNumber) {
		String exchStr = phNumber.substring(6, 9);
		int exchInt = Integer.parseInt(exchStr);
		return exchInt;
	}

	private int parseNumber(String phNumber) {
		String numStr = phNumber.substring(10, 14);
		int numInt = Integer.parseInt(numStr);
		return numInt;
	}

	public void dial() {
		System.out.println("Dialing number: (" + areaCode + ") " + exchange
				+ "-" + number);
	}

	// Additional methods can be written here but omitted.
}
