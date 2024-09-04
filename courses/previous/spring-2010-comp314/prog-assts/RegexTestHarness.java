import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {

			System.out.println("Enter your regex: ");
			Pattern pattern = Pattern.compile(s.nextLine());

			System.out.println("Enter input string to search: ");
			Matcher matcher = pattern.matcher(s.nextLine());

			boolean found = false;
			while (matcher.find()) {
				System.out.println("I found the text \"" + matcher.group()
						+ "\" starting at index " + matcher.start()
						+ "and ending at index " + matcher.end());
				found = true;
			}
			if (!found) {
				System.out.println("No match found.");
			}
		}
	}
}