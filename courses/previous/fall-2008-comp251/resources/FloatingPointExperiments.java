public class FloatingPointExperiments {
	/**
	 * Return a string of "1"s and "0"s representing the
	 * bits in the computer's representation of the given
	 * double
	 * 
	 * @param val
	 *            The double whose bitwise representation
	 *            will be returned
	 * @return The bitwise representation of val, starting
	 *         with the most significant bit, with a space
	 *         between every 4th bit to improve readability
	 *         and a '|' between the sign and exponent, and
	 *         the exponent and significand
	 */
	public static String makeBitString(double val) {
		// the number of bits in a double in Java
		final int numBits = 64;

		// s will store the return value, built up one
		// character at a time from the left
		StringBuilder s = new StringBuilder();

		// This mask will "pick out" a single bit via the
		// bitwise & operator. It is initialized to the
		// value which happens to have only the most
		// significant bit set.
		long mask = 0x8000000000000000L;

		// Step through each bit, starting with the most
		// significant
		for (int i = 0; i < numBits; i++) {
			// insert a space before every 4th bit
			if (i % 4 == 0 && i > 0)
				s.append(" ");

			// insert a '|' between sign and exponent, and
			// exponent and significand
			if (i == 1)
				s.append("|");
			if (i == 12)
				s.append("| ");

			// if the ith bit from the left is set, insert a
			// 1, otherwise insert a 0
			if ((Double.doubleToRawLongBits(val) & mask) != 0) {
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
	 * Print the double, hexadecimal, and bitwise
	 * representations of the given double to standard
	 * output
	 * 
	 * @param val
	 *            The double whose representation should be
	 *            printed
	 */
	public static void showDoubleAndBits(double val) {
		System.out.format(
				"double: %g\nhex: %x\nbits: %s\n\n", val,
				Double.doubleToRawLongBits(val),
				makeBitString(val));
	}

	/**
	 * Demonstrate the bitwise and hex representations of
	 * certain interesting doubles
	 */
	public static void main(String arguments[]) {
		System.out.println("Counting up from zero:");
		for (int i = 0; i < 5; i++)
			showDoubleAndBits(i);
		System.out.println();

		System.out.println("Counting down from zero:");
		for (int i = 0; i > -5; i--)
			showDoubleAndBits(i);
		System.out.println();

		System.out
				.println("Counting up from 1 in powers of 2:");
		double val = 1;
		for (int i = 0; i < 5; i++) {
			System.out.println("2^(" + i + "):");
			showDoubleAndBits(val);
			val *= 2.0;
		}
		System.out.println();

		System.out
				.println("Counting down from 1 in powers of 2:");
		val = 1;
		for (int i = 0; i < 5; i++) {
			System.out.println("2^(" + i + "):");
			showDoubleAndBits(val);
			val /= 2.0;
		}
		System.out.println();

	}

	// Exercise: compute the next number in the sequence in
	// each of the above cases, then check your answers
	// using a modification of the above code

}
