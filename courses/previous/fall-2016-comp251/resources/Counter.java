public class Counter extends Thread {
	public static int x = 0;

	public static final int iterations = 10000;

	private int increment;

	public Counter(int increment) {
		this.increment = increment;
	}

	public void run() {
		for (int i = 0; i < iterations; i++) {
			x = x + increment;
		}
	}

	public static void main(String[] args)
			throws InterruptedException {
		Counter counter1 = new Counter(1);
		Counter counter2 = new Counter(-1);

		System.out.println("Initial value of x: " + x);

		System.out.println("x will be incremented and decremented exactly "
						+ iterations + " times each.");

		counter1.start();
		counter2.start();

		counter1.join();
		counter2.join();

		System.out.println("Final value of x: " + x);

	}

}
