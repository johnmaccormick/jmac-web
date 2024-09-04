public class SheepTracker3 {
	public final static int ITERATIONS = 100000;

	public static void main(String[] args) {
		SheepCounter3 sheepCounter = new SheepCounter3(50);
		Thread incrementor = new SheepIncrementor3(sheepCounter);
		Thread decrementor = new SheepDecrementor3(sheepCounter);

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

class SheepCounter3 {
	public int numSheep;

	public SheepCounter3(int numSheep) {
		this.numSheep = numSheep;
	}

	public void add(int amount) {
		numSheep += amount;
	}
}

class SheepIncrementor3 extends Thread {
	private SheepCounter3 sheepCounter;

	public SheepIncrementor3(SheepCounter3 sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker3.ITERATIONS; i++) {
			sheepCounter.add(1);
		}
	}
}

class SheepDecrementor3 extends Thread {
	private SheepCounter3 sheepCounter;

	public SheepDecrementor3(SheepCounter3 sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker3.ITERATIONS; i++) {
			sheepCounter.add(-1);
		}
	}
}
