
/**
 * EfficientCountZs demonstrates the concept of recursive problem
 * transformation by showing how we can achieve a more efficient
 * implementation to count the number of Z's in a string.
 * 
 * @author jmac
 *
 */
public class EfficientCountZs {
	/**
	 * Count the number of occurrences of the character 'Z' in a given
	 * string, starting and ending at given indices in the string.
	 * 
	 * @param s        The string whose 'Z' characters will be counted
	 * @param fromChar The index in s from which we should start counting
	 *                 'Z' characters (inclusive)
	 * @param toChar   The index in s up to which we should start counting
	 *                 'Z' characters (exclusive)
	 * @return The number of occurrences of the character 'Z' that occur in
	 *         s at or after fromChar, up to but not including toChar
	 */
	public static int efficientCountZs(String s, int fromChar,
			int toChar) {
		// Let us refer to the part of the string that we need to examine
		// as the "counting region". So the counting region begins at
		// fromChar and goes up to but not including toChar.
		int countingRegionLength = toChar - fromChar;

		// First base case: the counting region has length zero
		if (countingRegionLength == 0) {
			return 0;
		}
		// Second base case: the counting region has length 1
		else if (countingRegionLength == 1) {
			if (s.charAt(fromChar) == 'Z') {
				return 1;
			} else {
				return 0;
			}
		}
		// Recursive case: split the counting region into first character
		// and remaining characters
		else {
			int numZsInFirstChar = efficientCountZs(s, fromChar,
					fromChar + 1);
			int numZsInRemainingChars = efficientCountZs(s, fromChar + 1,
					toChar);
			return numZsInFirstChar + numZsInRemainingChars;
		}
	}

	public static void main(String[] args) {
		String[] strings = { "", "a", "Z", "aZ", "Za", "ZZ", "abZ", "aZb",
				"Zab", "acbZdefZghZZZ", "ZacbdefZghZZZ", "acbZdefZghZZZxyz" };
		for (String s : strings) {
			System.out.println(
					s + ": " + efficientCountZs(s, 0, s.length()));
		}
	}

}
