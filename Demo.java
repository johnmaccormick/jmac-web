import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

///////////////////////////////////////////////
// Is this a multi-threaded program ???????????
// How much CPU does it use, if you uncomment one, both or neither
// of the commented lines below?
///////////////////////////////////////////////

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {

		FileOutputStream fileOut = new FileOutputStream ("myfile.txt");
		PrintStream printOut = new PrintStream(fileOut);

		long counter = 0;
		long sum = 0;
		while(true)
		{
			counter++;
			sum += counter;
//			System.out.println(sum);
//			printOut.println(sum);
		}

	}

}
