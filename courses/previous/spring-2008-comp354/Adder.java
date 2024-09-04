import java.util.Date;

public class Adder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.nanoTime();

		long low = Integer.parseInt(args[0]);
		long high = Integer.parseInt(args[1]);
		int numThreads = Integer.parseInt(args[2]);
		long[] results = new long[numThreads];
		AdderThread[] threads = new AdderThread[numThreads];

		long range = high - low;
		for (int i = 0; i < numThreads; i++) {
			long this_low = low + (range * i) / numThreads;
			long this_high = low + (range * (i + 1)) / numThreads;
			threads[i] = new AdderThread(i, this_low, this_high, results);
			threads[i].start();
		}

		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println("Thread " + i + " was interrupted.");
				e.printStackTrace();
			}
		}

		long sum = 0;
		for (int i = 0; i < numThreads; i++) {
			sum += results[i];
		}

		long end = System.nanoTime();
		double duration = ((double) (end - start)) * 1.0e-9;

		System.out.println("sum: " + sum);
		System.out.println("duration: " + duration);
	}
}

class AdderThread extends Thread {
	int id;
	long low;
	long high;
	long[] results;

	/**
	 * @param low
	 * @param high
	 * @param result
	 */
	public AdderThread(int id, long low, long high, long[] results) {
		this.id = id;
		this.low = low;
		this.high = high;
		this.results = results;
	}

	/**
	 * 
	 */
	public void run() {
		long sum = 0;
		for (long i = low; i < high; i++) {
			sum += i;
		}
		results[id] = sum;
        //		System.out.println("id:" + id + " low:" + low + " high:" + high
        //				+ " sum:" + sum);
	}

}
