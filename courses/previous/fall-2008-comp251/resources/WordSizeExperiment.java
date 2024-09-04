public class WordSizeExperiment {
	private static final int numIters = 100000000;

	public static void doIntExperiment() {
		int val = 0;
		for (int i = 0; i < numIters; i++) {
				val += 12345;
				val += 23456;
				val += 34657;
				val += 45678;
				val += 56789;
				val += 12345;
				val += 23456;
				val += 34657;
				val += 45678;
				val += 56789;
		}
	}
	
	public static void doLongExperiment() {
		long val = 0;
		for (int i = 0; i < numIters; i++) {
				val += 12345L;
				val += 23456L;
				val += 34657L;
				val += 45678L;
				val += 56789L;
				val += 12345L;
				val += 23456L;
				val += 34657L;
				val += 45678L;
				val += 56789L;
		}
	}
	
	public static void main(String[] args) {
		long start, stop, durationInt, durationLong;
		for (int i = 0; i < 10; i++) {
			start = System.nanoTime();
			doIntExperiment();
			stop = System.nanoTime();
			durationInt = stop - start;

			start = System.nanoTime();
			doLongExperiment();
			stop = System.nanoTime();
			durationLong = stop - start;

			System.out.println((double) durationLong / durationInt);
		}
	}

}
