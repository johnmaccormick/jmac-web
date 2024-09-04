import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of methods for working with ArrayLists that
 * are useful when working with sorting / searching algorithms.
 *
 * @author John MacCormick
 * @author Based closely on Grant Braught's ArrayTools.java
 */
public class ArrayListTools {
    
    private static Random rnd = new Random();
    
    /**
     * Get an ArrayList of a specified length and fill it with random integers between min (inclusive)
     * and max (exclusive).
     * 
     * @param min smallest value that can appear in the ArrayList
     * @param max one larger than the largest value that can appear in the ArrayList
     * @param length the size of the ArrayList
     * @return the ArrayList of random values
     */
    public static ArrayList<Integer> getRandomIntArrayList(int min, int max, int length) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
 
        for (int i=0; i<length; i++) {
            arr.add(rnd.nextInt(max-min) + min);
        }
        
        return arr;
    }
    
    /**
     * Print out the contents of an integer ArrayList, ten items to a line.
     * 
     * @param arr the ArrayList of integers to be printed.
     */
    public static void printIntArrayList(ArrayList<Integer> arr) {
        int count = 0;
        for (int v : arr) {
            System.out.printf("%1$9d", v);
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    /**
     * Get a sub-array of the provided ArrayList.
     * 
     * @param arr the ArrayList from which to get the sub-array.
     * @param start the first index to include in the sub-array.
     * @param end one more than the last index to be included.
     * @return the sub-array of arr from start up to but not including end.
     */
    public static ArrayList<Integer> getSubArrayList(ArrayList<Integer> arr, int start, int end) {
        ArrayList<Integer> newArr = new ArrayList<>();
        for (int i = start; i < end; i++) {
			newArr.add(arr.get(i));
		}
        return newArr;
    }
}
