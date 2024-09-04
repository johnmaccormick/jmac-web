import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComplexityDemos {

	public static boolean contains(Set<Integer> set, int n) {
		for (int m : set) {
			if (n == m) {
				return true;
			}
		}
		return false;
	}

	public static boolean containsInverses(Set<Integer> set) {
		for (int n : set) {
			for (int m : set) {
				if (n == -m) {
					return true;
				}
			}
		}
		return false;
	}

	public static int sum(Set<Integer> set) {
		int total = 0;
		for (int n : set) {
			total += n;
		}
		return total;
	}

	public static void printSubsets(
			Set<Set<Integer>> subsets) {
		for (Set<Integer> set : subsets) {
			for (int n : set) {
				System.out.print(n);
			}
			System.out.println();
		}

	}

	public static boolean subsetSum(Set<Integer> set,
			int sum) {

		Set<Set<Integer>> subsets = new TreeSet<Set<Integer>>();
		Set<Integer> emptySet = new TreeSet<Integer>();

		subsets.add(emptySet);

		for (Integer n : set) {
			Set<Set<Integer>> newSubsets = new HashSet<Set<Integer>>(
					subsets);
			for (Set<Integer> subset : subsets) {
				Set<Integer> newSubset = new HashSet<Integer>(
						subset);
				newSubset.add(n);
				newSubsets.add(newSubset);
			}
			subsets = newSubsets;
		}

		// printSubsets(subsets);

		for (Set<Integer> subset : subsets) {
			if (sum(subset) == sum) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] values = { 1, 3, 5, 7, -3 };
		Set<Integer> set = new HashSet<Integer>();
		for (Integer n : values) {
			set.add(n);
		}

		int target = 14;

		System.out.println("Contains " + target + ": "
				+ contains(set, target));
		System.out.println("Contains inverses: "
				+ containsInverses(set));
		System.out.println("Contains subset summing to "
				+ target + ": " + subsetSum(set, target));
	}
}
