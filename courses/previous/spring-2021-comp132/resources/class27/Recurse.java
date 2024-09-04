
/**
 * The Recurse class contains two static functions that demonstrate some
 * elementary features of using recursion in Java.
 * 
 * @author jmac
 */
public class Recurse {

	/**
	 * A simple recursive function f(n) = 2n+f(n-1); f(1)=2. The function
	 * has a single base case and a single recursive case.
	 * 
	 * @param n The input to f(n), which should be a positive integer.
	 * @return The value of f(n) = 2n+f(n-1); f(1)=2.
	 */
	public static int f(int n) {
		if (n == 1) {
			return 2;
		} else {
			return 2 * n + f(n - 1);
		}
	}

	/**
	 * A recursive function g(n) = n-2g(n-2); g(1)=6; g(2)=3. The function
	 * has two base cases and a single recursive case.
	 * 
	 * @param n The input to g(n), which should be a positive integer.
	 * @return The value of g(n) = n-2g(n-2); g(1)=6; g(2)=3.
	 */
	public static int g(int n) {
		if (n == 1) {
			return 6;
		} else if (n == 2) {
			return 3;
		} else {
			return n - 1 + 2 * g(n - 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(f(3));
		System.out.println(g(4));
		System.out.println(g(5));
	}

}
