public class SheepTracker1 {
	public final static int OUTER_ITERATIONS = 1000000;
	public final static int INNER_ITERATIONS = 10;

	public static void main(String[] args) {
		SheepCounter sheepCounter = new SheepCounter(50);
		Thread incrementor = new SheepIncrementor(sheepCounter);
		Thread decrementor = new SheepDecrementor(sheepCounter);

		incrementor.start();
		decrementor.start();

		try {
			incrementor.join();
			decrementor.join();
		} catch (InterruptedException e) {
			System.out.println("thread was interrupted");
			e.printStackTrace();
		}

		System.out.println("Number of sheep is " + sheepCounter.numSheep);

	}

}

class SheepCounter {
	public int numSheep;

	public SheepCounter(int numSheep) {
		this.numSheep = numSheep;
	}
}

class SheepIncrementor extends Thread {
	private SheepCounter sheepCounter;

	public SheepIncrementor(SheepCounter sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker1.OUTER_ITERATIONS; i++) {
			int temp = sheepCounter.numSheep;
			for (int j = 0; j < SheepTracker1.INNER_ITERATIONS; j++) {
				temp = temp + 1;
			}
			sheepCounter.numSheep = temp;
		}
	}
}

class SheepDecrementor extends Thread {
	private SheepCounter sheepCounter;

	public SheepDecrementor(SheepCounter sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker1.OUTER_ITERATIONS; i++) {
			int temp = sheepCounter.numSheep;
			for (int j = 0; j < SheepTracker1.INNER_ITERATIONS; j++) {
				temp = temp - 1;
			}
			sheepCounter.numSheep = temp;
		}
	}
}
