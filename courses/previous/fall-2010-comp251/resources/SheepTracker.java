public class SheepTracker {
	public final static int ITERATIONS = 1000000;

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
		for (int i = 0; i < SheepTracker.ITERATIONS; i++) {
			sheepCounter.numSheep++;
		}
	}
}

class SheepDecrementor extends Thread {
	private SheepCounter sheepCounter;

	public SheepDecrementor(SheepCounter sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker.ITERATIONS; i++) {
			sheepCounter.numSheep--;
		}
	}
}
