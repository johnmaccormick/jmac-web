import java.text.DecimalFormat;

/**
 * An experiment that runs merge sort on arrays of various sizes and
 * measures its running time.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 20199
 */
public class MergeSortExperiment {

	private static int[] SIZES = { 1000, 2500, 5000, 7500, 10000, 15000,
			20000, 30000, 40000, 100000, 200000, 300000, 400000, 500000,
			600000, 700000, 800000, 1000000 };
	private static int TRIALS = 20;

	public static void main(String[] args) {

		System.out.println("Size\tTime (s)");

		for (int size : SIZES) {
			System.out.print(size + "\t");

			long totalNanos = 0;

			for (int t = 0; t < TRIALS; t++) {
				int[] arr = ArrayTools.getRandomIntArray(0, size, size);

				long startNanos = System.nanoTime();
				MergeSort.doMergeSort(arr);
				long endNanos = System.nanoTime();
				totalNanos = totalNanos + (endNanos - startNanos);
			}

			DecimalFormat df = new DecimalFormat("0.00000");
			System.out.println(df.format(totalNanos / 1e9 / TRIALS));
		}
	}
}
