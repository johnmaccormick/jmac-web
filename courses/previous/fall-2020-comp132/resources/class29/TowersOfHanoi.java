
/**
 * The TowersOfHanoi can print out solutions to the classic Towers of Hanoi
 * puzzle.
 * 
 * @author jmac
 */
public class TowersOfHanoi {

	/**
	 * Return the label of the "spare" peg in a puzzle move; this is the
	 * peg that is neither the source nor the destination of the move. For
	 * example, if the source is A and the destination is B, then the spare
	 * peg is C.
	 * 
	 * @param sourcePeg The peg from which disks will be moved
	 * @param destPeg   The peg to which disks will be moved
	 * @return The unique peg that is neither the source nor the
	 *         destination.
	 */
	private static char calculateSparePeg(char sourcePeg, char destPeg) {
		if ('A' != sourcePeg && 'A' != destPeg) {
			return 'A';
		} else if ('B' != sourcePeg && 'B' != destPeg) {
			return 'B';
		} else {
			return 'C';
		}
	}

	/**
	 * Print out the solution to a Towers of Hanoi puzzle.
	 * 
	 * We assume there are three pegs labeled A, B, and C. Any puzzle move
	 * has a source peg, a destination peg, and a spare peg.
	 * 
	 * The approach is recursive. The tower of disks to be moved is divided
	 * into two parts: the bottom disk and the upper disks. We first move
	 * the upper disks (via a recursive call) to the spare peg. Then move
	 * the bottom disk to the destination peg. Finally, (via another
	 * recursive call) move the upper disks from the spare peg to the
	 * destination peg.
	 * 
	 * @param numDisks  The number of disks to be moved
	 * @param sourcePeg The label of the peg from which disks will be moved
	 * @param destPeg   The label of the peg to which disks will be moved
	 */
	public static void solve(int numDisks, char sourcePeg, char destPeg) {
		// Base case: moving a single disc.
		if (numDisks == 1) {
			System.out.println(sourcePeg + "->" + destPeg);
		} else { // Recursive case: see description above.
			char sparePeg = calculateSparePeg(sourcePeg, destPeg);
			solve(numDisks - 1, sourcePeg, sparePeg); // upper discs to spare peg
			solve(1, sourcePeg, destPeg); // bottom disk to destination
			solve(numDisks - 1, sparePeg, destPeg); // upper discs to destination
		}
	}

	public static void demo() {
		for (int i = 1; i <= 4; i++) {
			System.out.println();
			System.out.println(
					"--------------- " + i + " disks ----------------");
			solve(i, 'A', 'C');
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve(2, 'A', 'C');
	}

}
