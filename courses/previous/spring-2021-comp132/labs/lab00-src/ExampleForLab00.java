
public class ExampleForLab00 {

	// This is the "main" method
	public static void main(String[] args) {
		// Create a new Candidate object. The new object will be referred to as
		// candidate1 within the program. The candidate1 object will be initialized so
		// that the candidate's name is Indira Patel, the candidate's party is
		// Demopublican, and the candidate's number of votes is 35,400.
		Candidate candidate1 = new Candidate("Indira Patel", "Demopublican", 35400);

		// Use method calls and string concatenation to print out the candidate's name
		// and number of votes.
		System.out.println(candidate1.getName() + ": " + candidate1.getVotes());
	}

}
