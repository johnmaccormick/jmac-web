import java.util.ArrayList;

public class PrimitiveWrappers {
	public static void main(String[] args) {
		ArrayList<Integer> evenNumbers = new ArrayList<>();
		evenNumbers.add(2);
		evenNumbers.add(4);
		evenNumbers.add(6);
		evenNumbers.add(8);
		evenNumbers.add(10);

		for (int n : evenNumbers) {
			System.out.println(n);
		}

//		Double d = new Double(35.7);
//		Boolean b = new Boolean(false);
//
//		if (d.isInfinite()) {
//			System.out.println("d is infinite");
//		} else {
//			System.out.println("d is finite");
//		}
	}

}
