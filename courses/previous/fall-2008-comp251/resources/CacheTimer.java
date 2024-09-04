import java.util.Random;

public class CacheTimer {

	private static Random random = new Random();

	public static int do_experiment(int[] an_array,
			int array_size, long num_iterations) {
		int index = 0;
		for (long i = 0; i < num_iterations; i++) {
			index = an_array[index];
		}
		return index;
	}

	public static void main(String[] args) {
		int array_size = Integer.parseInt(args[0]);
		long num_iterations = 10000000;
		int[] an_array = new int[array_size];
		
		// put a random permutation in the array
		for (int i = 0; i < array_size; i++) {
			an_array[i]= i;
		}
		for (int i = 0; i < array_size; i++) {
			int index = random.nextInt(array_size);
			int temp = an_array[i];
			an_array[i] = an_array[index];
			an_array[index] = temp;
		}

		// "warm up" by doing an experiment without timing
		do_experiment(an_array, array_size, num_iterations);

		// now time the same experiment
		long start = System.nanoTime();
		do_experiment(an_array, array_size, num_iterations);
		long stop = System.nanoTime();
		long duration = stop - start;
		float access_time = duration / num_iterations;
		System.out
				.format(
						"average access time for element of integer array of size %d is %d nanoseconds.\n",
						array_size, (int)access_time);

	}

}
