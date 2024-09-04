import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * A simple demo of using multiple threads by implementing
 * the Runnable interface. This program simultaneously
 * writes several large files, with each file being written
 * in a separate thread.
 * 
 * @author jmac
 */
public class MultiFileWriter {

	public static void main(String[] args)
			throws FileNotFoundException {
		String[] filenames = { "a.txt", "b.txt", "c.txt",
				"d.txt" };
		for (String filename : filenames) {
			FileOutputStream out = new FileOutputStream(
					filename);
			SingleFileWriter s = new SingleFileWriter(out);
			Thread thread = new Thread(s);
			thread.start();
		}
	}

}

/**
 * A SingleFileWriter writes a single large file, using an
 * output stream provided to the constructor.
 * SingleFileWriter implements the Runnable interface so
 * that the file can be written in a separate thread.
 * 
 * Because this thread does not access any shared state, no
 * synchronization is required.
 * 
 * @author jmac
 */
class SingleFileWriter implements Runnable {
	// the stream which this SingleFileWriter will write to
	private FileOutputStream outStream;

	/**
	 * @param out
	 *            The stream which this SingleFileWriter
	 *            will write to
	 */
	public SingleFileWriter(FileOutputStream out) {
		outStream = out;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 * 
	 * This is the method that actually writes the file.
	 * Because it overrides the Runnable.run() method, which
	 * doesn't throw any exceptions, this method may not
	 * throw exceptions either. In the simplistic approach
	 * below, the entire method is therefore wrapped in a
	 * try/catch block, but a real program should do better
	 * exception handling.
	 */
	public void run() {
		try {
			System.out.println("Thread "
					+ Thread.currentThread().getId()
					+ " starting");
			final int fileLength = 100000;
			for (int i = 0; i < fileLength; i++) {
				// write a single null byte to the output
				// stream
				outStream.write(0);
			}
			outStream.close();
			System.out.println("Thread "
					+ Thread.currentThread().getId()
					+ " finished");
		} catch (Exception e) {
			System.out.println("Exception in SingleFileWriter.run: "
							+ e);
		}
	}
}
