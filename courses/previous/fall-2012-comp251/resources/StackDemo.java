public class StackDemo {

	public static int apple(int x) {
		int y = banana(x);
		return y + 4;
	}

	public static int banana(int x) {
		int y = coconut(x);
		int z = 5;
		int w = doughnut(z);
		return y + z + w;
	}

	public static int coconut(int x) {
		int y = doughnut(x);
		return y - 25;
	}

	public static int doughnut(int x) {
		int z = x + 5;
		return z / 3;
	}

	public static void main(String[] args) {
		int x = apple(5);
		System.out.println("x = " + x);
	}

}
