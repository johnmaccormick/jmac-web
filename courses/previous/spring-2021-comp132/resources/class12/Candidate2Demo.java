import java.util.ArrayList;

public class Candidate2Demo {

	/**
	 * A main method that constructs and manipulates some Candidate objects for the
	 * purposes of illustration.
	 * 
	 * @param args none
	 */
	public static void main(String[] args) {

		Candidate2 c1 = new Candidate2("Adi Gallia", Candidate2.DEMOCRAT, 100);
		Candidate2 c2 = new Candidate2("Mace Windu", Candidate2.REPUBLICAN, 50);
		Candidate2 c3 = new Candidate2("Depa Billaba", Candidate2.REPUBLICAN, 90);
		Candidate2 c4 = new Candidate2("Even Piell", Candidate2.REPUBLICAN, 120);
		Candidate2 c5 = new Candidate2("Yoda", "Libertarain", 80);
		Candidate2 c6 = new Candidate2("Saesee Tiin", "libertarian", 60);

		ArrayList<Candidate2> candidates = new ArrayList<Candidate2>();
		candidates.add(c1);
		candidates.add(c2);
		candidates.add(c3);
		candidates.add(c4);
		candidates.add(c5);
		candidates.add(c6);

		int republicanVotes = 0;
		for (Candidate2 candidate : candidates) {
			if (candidate.getParty().equals(Candidate2.REPUBLICAN)) {
				republicanVotes += candidate.getVotes();
			}
		}
		System.out.println("Total votes for republican candidates: " + republicanVotes);

		
		
		int libertarianVotes = 0;
		for (Candidate2 candidate : candidates) {
			if (candidate.getParty().equals("Libertarian")) {
				libertarianVotes += candidate.getVotes();
			}
		}
		System.out.println("Total votes for libertarian candidates: " + libertarianVotes);

	}
}
