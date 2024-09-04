import java.util.ArrayList;
import java.util.Collections;

/**
 * Demonstrate the use of java.util.Collections.sort() and
 * java.util.Collections.binarySearch() for sorting and searching
 * collections.
 * 
 * @author jmac
 */
public class CollectionSortingSearching {

	public static void main(String[] args) {

		// Create list of random integers.
		ArrayList<Integer> list = ArrayListTools.getRandomIntArrayList(1,
				100, 10);

		// Remember one of the elements so we can search for it later.
		int element = list.get(0);

		// Sort the list.
		Collections.sort(list);

		// Print out the sorted list.
		System.out.println("Sorted list:");
		ArrayListTools.printIntArrayList(list);

		// Search for the element recorded earlier and print out its index.
		int index = Collections.binarySearch(list, element);
		System.out.println("Index of " + element + " in the list:");
		System.out.println(index);
	}
}
