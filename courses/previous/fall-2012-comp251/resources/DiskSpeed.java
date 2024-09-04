import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author jmac
 * 
 */
public class DiskSpeed {
	public static final int MEGA = 1024 * 1024;

	/**
	 * The size of a temporary file that will be used for
	 * experiments with input and output, measured in
	 * megabytes
	 */
	public static final int FILE_SIZE = 5000;

	/**
	 * The name of the temporary file used for
	 * experimentation -- this must be on a local disk e.g.
	 * in the /var/tmp directory on a Mac, or in c:\temp on
	 * Windows
	 */
	public static final String TEMP_FILE_NAME = "/var/tmp/asdf.txt";
//	public static final String TEMP_FILE_NAME = "c:\\temp\\asdf.txt";

	private static Random random = new Random();

	private static SortedSet<Long> diskTimes = new TreeSet<Long>();

	public static long getMedianDiskTime() {
		int middleIndex = diskTimes.size() / 2;
		int i = 0;
		for (long val : diskTimes) {
			if (i == middleIndex) {
				return val;
			}
			i++;
		}
		// impossible to get here unless set was empty
		return -1;
	}

	/**
	 * Create a (large) file of size FILE_SIZE megabytes,
	 * that will later be used for experiments with input
	 * and output. We write some data into the entire file
	 * to ensure that space is actually allocated for this
	 * file on the disk.
	 */
	public static void createHugeFile() throws IOException {
		File file = new File(TEMP_FILE_NAME);
		if (file.exists()) {
			if (file.length() == (long) FILE_SIZE * MEGA) {
				System.out
						.println("file of size "
								+ FILE_SIZE
								+ "MB already exists -- skipping file creation");
				return;
			}
		}

		System.out.println("creating file of size "
				+ FILE_SIZE + " megabytes...");

		FileOutputStream outFile = new FileOutputStream(
				TEMP_FILE_NAME);

		// create a 1 MB array with some (irrelevant) data
		// in it

		byte[] b = new byte[MEGA];
		for (int i = 0; i < MEGA; i++) {
			b[i] = (byte) i;
		}
		// repeatedly append the data to the file
		for (int i = 0; i < FILE_SIZE; i++) {
			outFile.write(b);
			if (i % 100 == 0) {
				System.out.println(i
						+ " megabytes completed");
			}
		}

		outFile.close();

		System.out.println("   ...finished creating file.");
		System.out.println();
	}

	/**
	 * Read chunkSize characters starting from a random
	 * location in the huge file. Nothing is done with the
	 * data that is read -- the only point of this method is
	 * to soak up some I/O resources. Return the wall clock
	 * time taken, in nanoseconds.
	 */
	public static long readRandomChunk(int chunkSize)
			throws IOException {
		long startTime = System.nanoTime();
		long startPosition = Math.abs(random.nextLong())
				% ((long) FILE_SIZE * MEGA - chunkSize);
		FileInputStream inFile = new FileInputStream(
				TEMP_FILE_NAME);
		byte[] b = new byte[chunkSize];
		inFile.skip(startPosition);
		inFile.read(b);
		inFile.close();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	public static void usage() {
		System.out.println("usage: java DiskSpeed chunksize");
		System.out.println("The program will estimate the time to read chunksize");
		System.out.println("bytes sequentially from a random initial location.");
		System.exit(-1);
	}
	
	public static void main(String[] args)
			throws IOException {
		if (args.length != 1) {
			usage();
		}
		int chunkSize = Integer.parseInt(args[0]);
		// the number of seconds between printing results
		int printInterval = 2;
		long lastPrintTime = System.nanoTime();
		createHugeFile();
		while (true) {
			long diskTime = readRandomChunk(chunkSize);
			diskTimes.add(diskTime);
//			System.out.print(".");
			if (System.nanoTime() > lastPrintTime
					+ (long) ((double) printInterval * 1e9)) {
				lastPrintTime = System.nanoTime();
				System.out.println("median disk time to read "
						+ chunkSize + " bytes: "
						+ (double) getMedianDiskTime()/1e9 + " seconds");
			}
		}
	}

}
