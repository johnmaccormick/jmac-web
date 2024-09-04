
/**
 * A WinningMovie object stores information about a movie that won the
 * Palme d'Or.
 * 
 * @author jmac
 *
 */
public class WinningMovie {
	private int yearWon; // The year this movie won the Palme d'Or
	private String title;
	private String director;

	/**
	 * Construct a new WinningMovie object with the given values.
	 * 
	 * @param yearWon  The year this movie won the Palme d'Or
	 * @param title    The title of the movie
	 * @param director The director of the movie
	 */
	public WinningMovie(int yearWon, String title, String director) {
		this.yearWon = yearWon;
		this.title = title;
		this.director = director;
	}

	/**
	 * @return the yearWon
	 */
	public int getYearWon() {
		return yearWon;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	@Override
	public String toString() {
		return title + " (" + director + ", " + yearWon + ")";
	}

}
