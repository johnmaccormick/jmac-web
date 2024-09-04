
/**
 * What is the asymptotic running time of the methods in this class?
 * 
 * @author jmac
 *
 */
public class RunningTimePractise {

	public static int mystery1(int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += i;
		}
		return total;
	}

	public static int mystery2(int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				total += i * j;
			}
		}
		return total;
	}

	public static int mystery3(int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					total += i * j * k;
				}
			}
		}
		return total;
	}

}
