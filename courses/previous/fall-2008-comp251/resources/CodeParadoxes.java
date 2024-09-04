public class CodeParadoxes {

	public static void infiniteLoop() {
		System.out.println("starting infinite loop now...");
		int i = 1;
		while (i > 0) {
			i++;
		}
		System.out.println("...should never get here");
	}
	
	public static void repeatedAddition() {
		float x = 200000;
		int iterations = 100;
		float increment = (float) (1.0 / iterations);
		float y = x;
		for (int i = 0; i < iterations; i++) {
			y = y + increment;
		}
		System.out.println(y);
	}
	
	public static void repeatedAdditionVerbose() {
		float x = 1000;
		int iterations = 10000;
		float increment = (float) (1.0 / iterations);
		float y = x;
		for (int i = 0; i < iterations; i++) {
			y = y + increment;
		}
		float expectedResult = x + iterations * increment;
		float actualResult = y;
		float difference = actualResult - expectedResult;
		System.out.println("Expected result was "
				+ expectedResult);
		System.out.println("Actual result was "
				+ actualResult);
		System.out.println("Difference is " + difference);
	}

	
	
	static final int ARRAY_SIZE = 4000;

	public static void initialize2DimArrayByRows() {
		int[][] anArray = new int[ARRAY_SIZE][ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++) {
			for (int j = 0; j < ARRAY_SIZE; j++) {
				anArray[i][j] = 1;
			}
		}
	}

	public static void initialize2DimArrayByColumns() {
		int[][] anArray = new int[ARRAY_SIZE][ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++) {
			for (int j = 0; j < ARRAY_SIZE; j++) {
				anArray[j][i] = 1;
			}
		}
	}

	public static void timeArrayInitializations() {
		long start, stop, rowDuration, columnDuration;
		
		// record time taken to initialize by rows
		start = System.nanoTime();
		initialize2DimArrayByRows();
		stop = System.nanoTime();
		rowDuration = stop - start;
		
		// record time to initialize by columns
		start = System.nanoTime();
		initialize2DimArrayByColumns();
		stop = System.nanoTime();
		columnDuration = stop - start;
		
		// print out results
		System.out.println("row duration: "+ rowDuration);
		System.out.println("column duration: "+ columnDuration);
		System.out.println("row and column durations differ by a factor: "
				+ (double) columnDuration / rowDuration);
	}




	public static void main(String[] args) {
		repeatedAddition();
//		infiniteLoop();
//		timeArrayInitializations();
	}

}
