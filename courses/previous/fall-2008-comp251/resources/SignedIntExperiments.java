/**
 * @author jmac
 * 
 */
public class SignedIntExperiments {

	/**
	 * Return a string of "1"s and "0"s representing the
	 * bits in the computer's representation of the given
	 * integer
	 * 
	 * @param val
	 *            The integer whose bitwise representation
	 *            will be returned
	 * @return The bitwise representation of val, starting
	 *         with the most significant bit, and with a
	 *         space between every 4th bit to improve
	 *         readability
	 */
	public static String makeBitString(int val) {
		// the number of bits in an int in Java
		final int numBits = 32;

		// s will store the return value, built up one
		// character at a time from the left
		StringBuilder s = new StringBuilder();

		// This mask will "pick out" a single bit via the
		// bitwise & operator. It is initialized to the
		// value which happens to have only the most
		// significant bit set.
		int mask = 0x80000000;

		// Step through each bit, starting with the most
		// significant
		for (int i = 0; i < numBits; i++) {
			// insert a space before every 4th bit
			if (i % 4 == 0 && i > 0)
				s.append(" ");

			// if the ith bit from the left is set, insert a
			// 1, otherwise insert a 0
			if ((val & mask) != 0) {
				s.append("1");
			} else {
				s.append("0");
			}

			// we must use Java's unsigned shift operator,
			// >>>, to shift the mask over by 1 bit
			mask = mask >>> 1;
		}
		return s.toString();
	}

	/**
	 * Print the integer, hexadecimal, and bitwise
	 * representations of the given integer to standard
	 * output
	 * 
	 * @param val
	 *            The integer whose representation should be
	 *            printed
	 */
	public static void showIntegerAndBits(int val) {
		System.out.format("int: %d hex: %x bits: %s\n",
				val, val, makeBitString(val));
	}

	/**
	 * Demonstrate the bitwise and hex representations of
	 * certain interesting integers
	 */
	public static void main(String arguments[]) {
		System.out.println("Counting up from zero:");
		for (int i = 0; i < 8; i++)
			showIntegerAndBits(i);
		System.out.println();

		System.out.println("Counting down from zero:");
		for (int i = 0; i > -8; i--)
			showIntegerAndBits(i);
		System.out.println();

		System.out
				.println("Counting down from Integer.MAX_VALUE:");
		for (int i = Integer.MAX_VALUE; i > Integer.MAX_VALUE - 8; i--)
			showIntegerAndBits(i);
		System.out.println();

		System.out
				.println("Counting up from Integer.MIN_VALUE:");
		for (int i = Integer.MIN_VALUE; i < Integer.MIN_VALUE + 8; i++)
			showIntegerAndBits(i);
		System.out.println();
	}

	// Exercise: compute the hex and 2's complement bit
	// representations of the following six decimal integers
	// *by hand*, then check your answers using a modification
	// of the above code:
	//
	// 9, -9, 19, -19, (2^20+1), (Integer.MIN_VALUE/2)
}
