/**
 * Representation of a candidate running for office.
 *
 * @author Grant Braught, revised by Farhan Siddiqui and John MacCormick
 * @author Dickinson College
 * @version June 2020
 */
public class Candidate2 {
	/**
	 * Democratic party.
	 */
	public static final String DEMOCRAT = "Democrat";

	/**
	 * Republican party.
	 */
	public static final String REPUBLICAN = "Republican";

	/**
	 * Libertarian party.
	 */
	public static final String LIBERTARIAN = "Libertarian";

	/**
	 * Independent party.
	 */
	public static final String INDEPENDENT = "Independent";

	private String name;
	private String party;
	private int votes;

	/**
	 * Construct a new candidate with the specified name, party and number of votes.
	 * 
	 * @param name  the candidate's name
	 * @param party the candidate's party
	 * @param votes the number of votes that this candidate has.
	 */
	public Candidate2(String candidateName, String candidateParty, int candidateVotes) {
		name = candidateName;
		party = candidateParty;
		votes = candidateVotes;
	}

	/**
	 * Retrieve the candidate's name.
	 * 
	 * @return the candidate's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the candidate's party.
	 * 
	 * @return the candidate's party.
	 */
	public String getParty() {
		return party;
	}

	/**
	 * Retrieve the number of votes that have been cast for this candidate.
	 * 
	 * @return this candidate's votes.
	 */
	public int getVotes() {
		return votes;
	}

	/**
	 * Change the candidate's party affiliation.
	 * 
	 * @param newParty the candidate's new party.
	 */
	public void setParty(String newParty) {
		party = newParty;
	}

	/**
	 * Increase the number of votes for this candidate by one
	 *
	 *
	 */
	public void increaseVotes() {
		votes++;
	}

	/**
	 * Increase the number of votes for this candidate by a specified number
	 *
	 *
	 */
	public void increaseVotes(int voteCount) {
		votes = votes + voteCount;
	}

	/**
	 * Determine if this candidate defeated another candidate: e.g.
	 * joe.defeated(sam)
	 * 
	 * @param opp the opponent of this candidate.
	 * @return true if this candidate defeated the opponent.
	 */
	public boolean defeated(Candidate2 opp) {
		if (this.getVotes() > opp.getVotes()) {
			return true;
		} else {
			return false;
		}
	}

}