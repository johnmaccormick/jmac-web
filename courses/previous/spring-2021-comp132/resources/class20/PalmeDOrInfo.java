import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A PalmeDOrInfo Object can be used to store information about the winners
 * of the Palme d'Or, which is the top prize at the Cannes film Festival.
 * 
 * @author jmac
 *
 */
public class PalmeDOrInfo {
	// This field stores a collection of movies that have won the Palme
	// d'Or. It is a map in which the keys are years and the values are
	// references to winning movies. Specifically, each entry in the map is
	// a key-value pair in which the key is a year (e.g. 1979) and the
	// value is a reference to the movie that won the Palme d'Or in that
	// year (e.g. 1979 maps to Apocalypse Now).
	private HashMap<Integer, WinningMovie> winners;

	/**
	 * Construct a new PalmeDOrInfo object containing an empty map of
	 * winning movies.
	 */
	public PalmeDOrInfo() {
		winners = new HashMap<>();
	}

	/**
	 * Add the given movie to the map of winning movies.
	 * 
	 * @param wm The winning movie to be added
	 */
	public void addMovie(WinningMovie wm) {
		int year = wm.getYearWon();
		winners.put(year, wm);
	}

	/**
	 * Return the movie that won the Palme d'Or in the given year, if
	 * known.
	 * 
	 * @param yearWon We want to find the movie that won the Palme d'Or in
	 *                this given year.
	 * @return The movie that won the Palme d'Or in the given year, or null
	 *         if no information is stored for that year.
	 */
	public WinningMovie getMovie(int yearWon) {
		return winners.get(yearWon);
	}

	/**
	 * Print all stored information about the winning movies.
	 */
	public void print() {
		Set<Integer> years = winners.keySet();
		for (Integer year : years) {
			System.out.println(winners.get(year));
		}
	}

	/**
	 * Print information about a winning movie based on a year entered by
	 * the user.
	 * 
	 * @param p A PalmeDOrInfo object containing information about some
	 *          movies that have won the Palme d'Or.
	 */
	public static void findMovie(PalmeDOrInfo p) {
		// Allow the user to enter a year.
		System.out.print("Enter year: ");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();

		// Print information about the winning movie from the entered year,
		// if known.
		WinningMovie movie = p.getMovie(year);
		if (movie != null) {
			System.out.println(movie);
		} else {
			System.out.println("The winner for that year is unknown.");
		}
	}

	public static void main(String[] args) {
		WinningMovie wm1 = new WinningMovie(1979, "Apocalypse Now",
				"Francis Ford Coppola");
		WinningMovie wm2 = new WinningMovie(1991, "Barton Fink",
				"Joel and Ethan Coen");
		WinningMovie wm3 = new WinningMovie(1993, "The Piano",
				"Jane Campion");
		WinningMovie wm4 = new WinningMovie(1994, "Pulp Fiction",
				"Quentin Tarantino");
		WinningMovie wm5 = new WinningMovie(2019, "Parasite",
				"Bong Joon-ho");

		WinningMovie[] movies = { wm1, wm2, wm3, wm4, wm5 };

		PalmeDOrInfo p = new PalmeDOrInfo();

		for (WinningMovie wm : movies) {
			p.addMovie(wm);
		}

		findMovie(p);

//		p.print();

	}

}
