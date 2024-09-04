
/**
 * First examples of using a for loop. This class doesn't do any meaningful
 * computation, it simply serves as a demonstration of the execution of a for
 * loop.
 * 
 * @author Grant Braught, edits by John MacCormick
 * 
 */
public class FirstForLoop {
	public void incrementDemo() {
		int n = 5;
		System.out.println("n before increment: " + n);
		
		// This increments the value of n by one.
		n++;
		
		System.out.println("n after increment: " + n);

		int m = 10;
		System.out.println("m before decrement: " + m);
		
		// This decrements the value of m by one.
		m--;
		
		System.out.println("m after decrement: " + m);
	
	}
	
	
	/**
	 * Demonstrate the operation of a for loop.
	 */
	public void forLoopDemo() {
		for (int num = 0; num < 5; num++) {
			System.out.println(2 * num - 1);
		}
	}

	/**
	 * Another demonstration of a for loop
	 */
	public void forLoopDemoTwo() {
		for (int num = 10; num >= 0; num--) {
			System.out.println(num / 2 + 1);
		}
	}

	/**
	 * Yet another demonstration of a for loop
	 */
	public void forLoopDemoThree() {
		for (int num = 1; num <= 64; num = num * 2) {
			System.out.println("num: " + num + "  num squared: " + num * num);
		}
	}

	public static void main(String[] args) {
		FirstForLoop loopDemo = new FirstForLoop();

		System.out.println("Increment demo...");
		loopDemo.incrementDemo();
		
		System.out.println();
		System.out.println("First demo...");
		loopDemo.forLoopDemo();
		
		System.out.println();
		System.out.println("Second demo...");
		loopDemo.forLoopDemoTwo();

		System.out.println();
		System.out.println("Third demo...");
		loopDemo.forLoopDemoThree();
	}

}
