import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A JavaAnalyzer analyzes a single file containing Java
 * source code, and prints out a list of the fields,
 * constructors, and methods defined in the file,
 * together with the line numbers where these entities may be found.
 * A typical output might be:
 * <P><BLOCKQUOTE><TT>
 * fields:<br>
 * line 14:        private String label;<br>
 * <br>
 * constructors:<br>
 * line 27:        public DfaVertex(String label)<br>
 * <br>
 * methods:<br>
 * line 43:        public void addTransition(String symbol, String dest)<br>
 * line 57:        public String getTransition(String symbol)<br>
 * line 64:        public String getLabel()<br>
 * </TT></BLOCKQUOTE><P>
 *
 * @author jmac
 * @version February 2010
 */
public class JavaAnalyzer {
	// the name of the java file to be analyzed
	private final String filename;

	// stores the number of the most recently read line in
	// the java file being analyzed
	private int lineNumber;

    // PROGASSIGNMENT2: add new fields here

	/**
	 * Construct a new JavaAnalyzer object that will analyze
	 * the Java code in the given file
	 * 
	 * @param filename
	 *            the name of the Java file to be analyzed
	 */
	public JavaAnalyzer(String filename) {
		this.filename = filename;
		lineNumber = 0;
        // PROGASSIGNMENT2: add new constructor code here
	}

	/**
	 * Perform the analysis of this JavaAnalyzer's java
	 * file, and print out the results. Specifically, the
	 * fields, methods, and constructors will be detected
	 * and descriptions of them will be printed.
	 */
	public void analyze() {
		Scanner scanner = null;
		try {
			File file = new File(filename);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				lineNumber++;
				String line = scanner.nextLine();
				processLine(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			// ensure the underlying stream is always closed
			if (scanner != null)
				scanner.close();
		}

		printResults();

	}

	// Analyze the given line of Java code to determine if
	// it is the definition of a field, constructor, or
	// method. If so, the necessary information about the
	// field, constructor, or method is stored so that it
	// can be printed out later.
	private void processLine(String line) {
        // PROGASSIGNMENT2: fill in method body
	}

	// print out descriptions of the fields, then the
	// constructors, then the methods.
	private void printResults() {
        // PROGASSIGNMENT2: fill in method body
	}

	/**
	 * Print a usage message.
	 */
	public static void usage() {
		System.out.println("usage: JavaAnalyzer filename.java");
		System.exit(1);
	}

	/**
	 * The main method expects one argument, which is the
	 * filename of the java file to be analyzed.
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			usage();
		}

		String filename = args[0];
		JavaAnalyzer analyzer = new JavaAnalyzer(filename);
		analyzer.analyze();
	}
}
