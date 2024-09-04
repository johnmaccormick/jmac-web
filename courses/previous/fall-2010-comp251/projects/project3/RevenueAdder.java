import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RevenueAdder {

	public static float computeRevenue(String filename)
			throws FileNotFoundException {
		float sum = 0.0f;
		Scanner s = null;
		s = new Scanner(new BufferedReader(new FileReader(
				filename)));

		while (s.hasNextFloat()) {
			sum += s.nextFloat();
		}
		s.close();

		return sum;
	}

	public static void usage() {
		System.out.println("usage: java RevenueAdder filename");
		System.exit(0);
	}

	public static void main(String[] args)
			throws FileNotFoundException {
		if (args.length != 1) {
			usage();
		}
		
		String filename = args[0];
		System.out.println("Total revenue is "
				+ computeRevenue(filename));
	}

}
