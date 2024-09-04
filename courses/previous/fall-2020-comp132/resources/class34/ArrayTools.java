import java.util.Random;

/**
 * A collection of methods for working with arrays that
 * are useful when working with sorting / searching algorithms.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class ArrayTools {
    
    private static Random rnd = new Random();
    
    /**
     * Get an array of a specified length and fill it with random integers between min (inclusive)
     * and max (exclusive).
     * 
     * @param min smallest value that can appear in the array
     * @param max one larger than the largest value that can appear in the array
     * @param length the size of the array
     * @return the array of random values
     */
    public static int[] getRandomIntArray(int min, int max, int length) {
        int[] arr = new int[length];
 
        for (int i=0; i<arr.length; i++) {
            arr[i] = rnd.nextInt(max-min) + min;
        }
        
        return arr;
    }
    
    /**
     * Print out the contents of an integer array, ten items to a line.
     * 
     * @param arr the array of integers to be printed.
     */
    public static void printIntArray(int[] arr) {
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
     * Get a sub-array of the provided array.
     * 
     * @param arr the array from which to get the sub-array.
     * @param start the first index to include in the sub-array.
     * @param end one more than the last index to be included.
     * @return the sub-array of arr from start up to but not including end.
     */
    public static int[] getSubarray(int[] arr, int start, int end) {
        int[] newArr = new int[end - start];
        System.arraycopy(arr, start, newArr, 0, newArr.length);
        return newArr;
    }
}
