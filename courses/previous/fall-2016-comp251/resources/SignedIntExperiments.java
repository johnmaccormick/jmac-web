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
        // this gives the binary representation but without leading zeros
        String unformattedBits = Integer.toBinaryString(val);
        final int numBits = 32;
        // pad with leading zeros to explicitly represent all 32 bits
        int numZeros = numBits - unformattedBits.length();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<numZeros; i++){
            sb1.append("0");
        }
        sb1.append(unformattedBits);
        String paddedBits = sb1.toString();
        // insert a space before every 4th bit
        StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < numBits; i++) {
            sb2.append(paddedBits.charAt(i));
			if (i % 4 == 3)
				sb2.append(" ");
        }
        return sb2.toString();
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
