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
	private HashMap<Integer, WinningMovie> winners;

	public PalmeDOrInfo() {
		winners = new HashMap<>();
	}

	public void addMovie(WinningMovie wm) {
		int year = wm.getYearWon();
		winners.put(year, wm);
	}

	public WinningMovie getMovie(int yearWon) {
		return winners.get(yearWon);
	}

	public void print() {
		Set<Integer> years = winners.keySet();
		for (Integer year : years) {
			System.out.println(winners.get(year));
		}
	}

	public static void findMovie(PalmeDOrInfo p) {
		System.out.print("Enter year: ");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();

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
