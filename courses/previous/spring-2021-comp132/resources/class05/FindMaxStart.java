
/**
 * find the largest of 3 numbers.
 * 
 * @author Tim Wahls, edited by John MacCormick
 *
 */
public class FindMaxStart {
	// the three numbers
	private int num1;
	private int num2;
	private int num3;

	/**
	 * set the 3 numbers to find the max of
	 * 
	 * @param init1 first number
	 * @param init2 second number
	 * @param init3 third number
	 */
	public FindMaxStart(int init1, int init2, int init3) {
		num1 = init1;
		num2 = init2;
		num3 = init3;
	}

	/**
	 * return the maximum of the three numbers set by the constructor
	 * 
	 * @return the maximum of the three numbers
	 */
	public int max3() {
		if (num1 >= num2) {
			if (num1 >= num3) {
				return num1;
			}
		}
		// delete following line and replace with your code
		return 0;
	}

	// Challenge: fill in the '//??' so that the maximum is returned
	public int max3b() {
		if (!(num1 < num2 || num1 < num3)) {
			// ??
			return 0;
		} else if (!(!(num2 >= num1) || ((num2 <= num3) && (num2 != num3)))) {
			// ??
			return 0;
		} else {
			// ??
			return 0;
		}
	}

}
