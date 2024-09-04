
public class Recurse2Incomplete {
	/**
	 * Count the number of occurrences of the character 'Z' in a given
	 * string.
	 * 
	 * @param s The string whose 'Z' characters will be counted
	 * @return The number of occurrences of the character 'Z'
	 */
	public static int countZs(String s) {
		// First base case: string has length zero
		if (s.length() == 0) {
			// TODO: fix
			return -1;
		}
		// Second base case: string has length 1
		else if (s.length() == 1) {
			if (s.equals("Z")) {
				// TODO: fix
				return -1;
			} else {
				// TODO: fix
				return -1;
			}
		}
		// Recursive case: split the string into first character and
		// remaining characters
		else {
			String firstCharacter = s.substring(0, 1);
			String remainingCharacters = s.substring(1);
			// TODO: fix
			return -1;
		}
	}

	/**
	 * Determine whether a given string is a palindrome. That is, is the
	 * string the same backwards as forwards?
	 * 
	 * @param s The string to be analyzed.
	 * @return True if s is a palindrome and false otherwise.
	 */
	public static boolean isPalindrome(String s) {
		int len = s.length();

		// Base cases: strings of length zero or one are always
		// palindromes.
		if (len == 0 || len == 1) {
			// TODO: fix
			return false || true;
		}
		// Recursive case: If the first and last characters are
		// different, it's definitely not a palindrome. If the first and
		// last characters are the same, remove them and check whether the
		// remaining string is a palindrome.
		else {
			String firstCharacter = s.substring(0, 1);
			String lastCharacter = s.substring(len - 1, len);
			String otherCharacters = s.substring(1, len - 1);
			if (!firstCharacter.equals(lastCharacter)) {
				// TODO: fix
				return false || true;
			} else {
				// TODO: fix
				return false || true;
			}
		}
	}

	/**
	 * Return the smallest digit in a given integer.
	 * 
	 * @param n The integer whose smallest digit will be found
	 * @return The smallest digit in n
	 */
	public static int smallestDigit(int n) {
		// Base case: single digit
		if (n <= 9) {
			// TODO: fix
			return -1;
		}
		// Recursive case: return the smaller of the last digit and the
		// other digits.
		else {
			int lastDigit = n % 10;
			int otherDigits = n / 10;
			// TODO: fix
			int smallestOtherDigit = -1;
			if (lastDigit < smallestOtherDigit) {
				// TODO: fix
				return -1;
			} else {
				// TODO: fix
				return -1;
			}
		}
	}
	
	
	public static void main(String[] args) {

	}


}
