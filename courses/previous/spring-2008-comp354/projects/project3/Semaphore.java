

/**
 * A java implementation of a Semaphore.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 9, 2006
 */
public class Semaphore {

	private int value;

	/**
	 * Construct a new Semaphore with initial value of 0.
	 */
	public Semaphore() {
		value = 0;
	}

	/**
	 * Construct a new Semaphore with the specified initial value.
	 * @param initVal the initial value for this Semaphore.
	 */
	public Semaphore(int initVal) {
		value = initVal;
	}

	/**
	 * Decrement the value of this Semaphore and block if the 
	 * value has become negative.
	 */
	public synchronized void semWait() {
		value--;
		if (value < 0) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				System.out.println(e);
				System.exit(-1);
			}
		}
	}

	/**
	 * Increment the value of this Semaphore and wake up a thread
	 * if any are blocked.
	 */
	public synchronized void semSignal() {
		value++;
		notify();
	}
}
