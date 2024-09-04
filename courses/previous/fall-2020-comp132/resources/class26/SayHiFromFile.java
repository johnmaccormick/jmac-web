import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * SayHiFromFile demonstrates the use of exceptions in a realistic
 * application. The main() method reads a name from a file and prints out a
 * greeting followed by that name. Reading from a file can throw
 * exceptions. For example, the file may not exist or the program may not
 * have permission to read the file. Therefore, we need to handle such
 * exceptions appropriately.
 * 
 * This example is adapted from code provided in the official Java tutorial
 * pages at <a href=
 * "https://docs.oracle.com/javase/tutorial/essential/io/file.html">https://docs.oracle.com/javase/tutorial/essential/io/file.html</a>.
 * 
 * See the tutorial section "Writing a File by Using Buffered Stream I/O"
 * 
 * @author jmac
 *
 */
public class SayHiFromFile {
	public static void main(String[] args) {
		String filename = "src/myName.txt";
		Charset charset = StandardCharsets.UTF_8;
		Path file = Paths.get(filename);
		String firstLine = null;
		try {
			BufferedReader reader = Files.newBufferedReader(file, charset);
			firstLine = reader.readLine();
			reader.close();
			System.out.println("Greetings, " + firstLine);
		} catch (IOException x) {
			System.err.println(
					"IOException thrown while trying to open the file "
							+ filename);
		}
	}
}
