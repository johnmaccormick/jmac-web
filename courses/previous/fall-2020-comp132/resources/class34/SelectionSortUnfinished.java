/**
 * Iterative and recursive implementations of the Selection Sort algorithm.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class SelectionSortUnfinished {

    /**
     * An iterative implementation of the selection sort algorithm.
     * 
     * @param arr the array to be sorted.
     * @return the sorted array.
     */
    public static int[] doSelectionSort(int[] arr) {
    	// TODO: Write this method.
    	return null;
    }

    /**
     * Find the index of the minimum value between the start index and the end
     * of the array.
     * 
     * @param arr the array to search.
     * @param start the index at which to start searching for the min.
     * @return the index of the minimum value.
     */
    private static int findIndexOfMin(int[] arr, int start) {
        int mindex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[mindex]) {
                mindex = i;
            }
        }
        return mindex;
    }

    /**
     * Swap the values at the specified indices in the array.
     * 
     * @param arr the array.
     * @param i1 index of one of the values to swap.
     * @param i2 index of the other value to swap.
     */
    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    /**
     * Sort a list consisting of integer values using the selection sort.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        int[] arr = ArrayTools.getRandomIntArray(0, 10000, 1000);
        arr = doSelectionSort(arr);
        ArrayTools.printIntArray(arr);
    }
    
    /*
     * The selection sort can also be written as a recursive program.
     * The two methods below provide a recursive implementation. It is a 
     * bit of a degenerate recursive solution, but another useful exercise
     * in thinking recursively none-the-less.
     */
    
    /**
     * A recursive implementation of the selection sort algorithm.
     * 
     * @param arr the array to be sorted.
     * @return the sorted array.
     */
    public static int[] recursiveSort(int[] arr) {
        return recursiveSortHelper(arr, 0);
    }

    /**
     * Helper method that actually does the recursive selection sort.
     * 
     * @param arr the array to sort.
     * @param start the index in the array at which to start sorting
     * @return the arr sorted from start to the end.
     */
    private static int[] recursiveSortHelper(int[] arr, int start) {
        if (start == arr.length - 1) {
            return arr;
        }
        else {
            int mindex = findIndexOfMin(arr, start);
            swap(arr, start, mindex); // sort the element at start
            recursiveSortHelper(arr, start + 1); // sort the rest
            return arr;
        }
    }
}

