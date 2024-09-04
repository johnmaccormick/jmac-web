
public class Recurse {

	public static int f(int n) {
		if (n == 1) {
			return 2;
		} else {
			return 2 * n + f(n - 1);
		}
	}

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
