public class BigODemo {

	/**
	 * Checks for duplicates in a sorted array of strings.
	 * 
	 * @param strings
	 *            An array of strings that has already been sorted into
	 *            alphabetical order.
	 * @return true if any pair of strings in the array are equal, otherwise
	 *         false.
	 */
	public static boolean containsDuplicates1(String[] strings) {
		// test every pair of strings
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				// if we have found a duplicate, we can return true right away
				if ((i != j) && strings[i].equals(strings[j])) {
					return true;
				}
			}
		}
		// we tested every pair of strings without finding a duplicate, so
		// return false
		return false;
	}

	/**
	 * Checks for duplicates in a sorted array of strings.
	 * 
	 * @param strings
	 *            An array of strings that has already been sorted into
	 *            alphabetical order.
	 * @return true if any pair of strings in the array are equal, otherwise
	 *         false.
	 */
	public static boolean containsDuplicates2(String[] strings) {
		// The strings are guaranteed to be sorted, so if there are any
		// duplicates, they must be adjacent. Therefore, step through the array
		// comparing only the consecutive pairs.
		for (int i = 0; i < strings.length - 1; i++) {
			if (strings[i].equals(strings[i + 1])) {
				// we found a duplicate, so return true
				return true;
			}
		}
		// no duplicates were found, so return false
		return false;
	}

}
