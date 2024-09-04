import java.util.HashMap;
import java.util.Map;

/**
 * FibonacciNumbers demonstrates two different approaches to using
 * recursion to compute the Fibonacci numbers. One of the approaches is
 * highly efficient because it stores previously computed values in a hash
 * table. The other approach uses elementary recursion, which in this case
 * can be slower by a huge factor (thousands, millions, or more, depending
 * on the value being computed).
 * 
 * @author jmac
 *
 */
public class FibonacciNumbers {
	/**
	 * This map will store all previously computed Fibonacci number values.
	 * In each key-value pair, the key is the input value, say n, and the
	 * value is the nth Fibonacci number.
	 */
	private Map<Long, Long> computedValues;

	public FibonacciNumbers() {
		this.computedValues = new HashMap<Long, Long>();

		// The first two Fibonacci numbers are both equal to 1. We insert
		// these values into the table of precomputed values now.
		computedValues.put(1L, 1L);
		computedValues.put(2L, 1L);
	}

	/**
	 * Return the value of the nth Fibonacci number using an efficient
	 * recursive approach that stores previously computed values in a hash
	 * table.
	 * 
	 * @param n The index of the desired Fibonacci number, which must be
	 *          positive.
	 * @return the nth Fibonacci number
	 */
	public long nthFibNum(long n) {
		if (computedValues.containsKey(n)) {
			// We've computed this value before, so return it.
			return computedValues.get(n);
		} else {
			// We need to compute a value that has not been computed
			// before, so we use the standard recursive formula for
			// Fibonacci numbers.
			long fibN = nthFibNum(n - 1) + nthFibNum(n - 2);
			// Store this newly computed value for later use.
			computedValues.put(n, fibN);

			return fibN;
		}
	}

	/**
	 * Return the value of the nth Fibonacci number using a simple
	 * recursive approach that can be extremely inefficient for modest
	 * values of n.
	 * 
	 * @param n The index of the desired Fibonacci number, which must be
	 *          positive.
	 * @return the nth Fibonacci number
	 */
	public long slowFib(long n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return slowFib(n - 1) + slowFib(n - 2);
		}
	}

	public static void main(String[] args) {
		FibonacciNumbers fib = new FibonacciNumbers();
		long n = 46;

		System.out.println("Starting computation using HashMap...");
		long t1 = System.nanoTime();
		long val1 = fib.nthFibNum(n);
		long d1 = System.nanoTime() - t1;
		System.out.println("answer=" + val1);
		System.out.format(
				"         ...finished (%d milliseconds : about %d microseconds)\n",
				d1 / 1000000L, d1 / 1000L);
		System.out.println();

		System.out.println("Starting computation without HashMap...");
		long t2 = System.nanoTime();
		long val2 = fib.slowFib(n);
		long d2 = System.nanoTime() - t2;
		System.out.println("answer=" + val2);
		System.out.format(
				"         ...finished (%d milliseconds : about %d microseconds)\n",
				d2 / 1000000L, d2 / 1000L);
	}

}
