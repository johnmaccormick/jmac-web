public class SheepTracker2 {
	public final static int ITERATIONS = 10000;

	public static void main(String[] args) {
		SheepCounter2 sheepCounter = new SheepCounter2(50);
		Thread incrementor = new SheepIncrementor2(sheepCounter);
		Thread decrementor = new SheepDecrementor2(sheepCounter);

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

class SheepCounter2 {
	public int numSheep;

	public SheepCounter2(int numSheep) {
		this.numSheep = numSheep;
	}
}

class SheepIncrementor2 extends Thread {
	private SheepCounter2 sheepCounter;

	public SheepIncrementor2(SheepCounter2 sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker2.ITERATIONS; i++) {
			sheepCounter.numSheep++;
		}
	}
}

class SheepDecrementor2 extends Thread {
	private SheepCounter2 sheepCounter;

	public SheepDecrementor2(SheepCounter2 sheepCounter) {
		this.sheepCounter = sheepCounter;
	}

	public void run() {
		for (int i = 0; i < SheepTracker2.ITERATIONS; i++) {
			sheepCounter.numSheep--;
		}
	}
}
