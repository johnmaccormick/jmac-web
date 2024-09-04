import java.util.Random;

/**
 * A RandomValues object stores an array of random integers. This array can be
 * used to demonstrate the concept of nested for loops.
 * 
 * @author jmac
 *
 */
public class RandomValues {
	// This will store a sequence of random integer values.
	private int[] randomVals;

	/**
	 * The maximum value that one of the random integers in the array can have.
	 * (Actually, the random integers will be strictly less than this maximum value,
	 * not equal to it.)
	 */
	public static final int MAX_VALUE = 8;

	/**
	 * Create a new RandomValues object storing the given number of random integer
	 * values.
	 * 
	 * @param numVals The number of random integer values that will be stored in
	 *                this object.
	 */
	public RandomValues(int numVals) {
		this.randomVals = new int[numVals];
		initializeVals();
	}

	// Initialize the array with random integer values.
	private void initializeVals() {
		Random rand = new Random();
		for (int i = 0; i < randomVals.length; i++) {
			randomVals[i] = rand.nextInt(MAX_VALUE);
		}
	}

	/**
	 * Print out the array of random integer values.
	 */
	public void printVals() {
		for (int i = 0; i < randomVals.length; i++) {
			System.out.print(randomVals[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Print out all pairs of values in the array that add to the given sum.
	 * 
	 * @param sum Pairs (x,y) such that x+y=sum will be printed
	 */
	public void printPairsWithSum(int sum) {
		for (int i = 0; i < randomVals.length; i++) {
			for (int j = 0; j < randomVals.length; j++) {
				if (randomVals[i] + randomVals[j] == sum) {
					System.out.println(randomVals[i] + ", " + randomVals[j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		RandomValues rv = new RandomValues(10);
		rv.printVals();
		rv.printPairsWithSum(11);
	}

}
