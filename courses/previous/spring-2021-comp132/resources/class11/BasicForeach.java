import java.util.ArrayList;

public class BasicForeach {
	public static void main(String[] args) {
		ArrayList<String> alphabet = new ArrayList<>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
		alphabet.add("d");
		alphabet.add("e");
		
		for (String s : alphabet) {
			System.out.println(s);
		}

		// Here is the equivalent for loop:
		
//		for (int i = 0; i < alphabet.size(); i++) {
//			String s = alphabet.get(i);
//			System.out.println(s);
//		}
	}

}
