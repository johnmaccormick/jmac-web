/**
 * Implementations of the Linear and Binary search algorithms.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class SearchUnfinished {

    /**
     * An iterative implementation of the linear search algorithm.
     * 
     * @param arr the array to be searched
     * @param value the value to be searched for.
     * @return the index where the value was found or -1 if it was not found.
     */
    public static int linearSearch(int[] arr, int value) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Search the specified array for the specified value
     * using the recursive binary search algorithm.
     * 
     * @param arr the array to be searched
     * @param value the value to search for
     * @return the index where value is found or -1 if value does
     * not appear in the array.
     */
    public static int binarySearch(int[] arr, int value) {
        return binarySearchHelper(arr, value, 0, arr.length-1); //calling the helper method
    }
    
    /**
     * Helper method for the recursive binary search.  This method does 
     * all of the work!
     * 
     * @param arr the array to be searched
     * @param value the value to search for
     * @param start the lowest index where value might be found
     * @param end the highest index where value might be found
     * @return the index where value is found or -1 if value does
     * not appear in the array.
     */
    private static int binarySearchHelper(int[] arr, int value, int start, int end) {
        if (start > end) {
            return -1;  // value not found.
        }
        else {
            int mid = (start + end) / 2;
            
            if (arr[mid] == value) {
                return mid;     // found it!
            }
            else if (arr[mid] < value) {
            	// TODO: The next line should use a recursive call
                return -1;
            }
            else {
            	// TODO: The next line should use a recursive call
                return -1;
            }
        }
    }
    
    /**
     * Search a list of integer values using the linear or binary search.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        
        int findMe = 5;
        int[] arr = ArrayTools.getRandomIntArray(0, 10, 10);
        
        ArrayTools.printIntArray(arr);
        int index = linearSearch(arr, findMe);
        System.out.println("Found " + findMe + " at " + index);
        
        //arr = MergeSort.sort(arr);
        //ArrayTools.printIntArray(arr);
        //int index = binarySearch(arr, findMe);
        //System.out.println("Found " + findMe + " at " + index);
    }
    
}
