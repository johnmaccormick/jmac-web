public class TruthTable {

	public static boolean f(boolean a, boolean b, boolean c) {
		return a && b && c;
	}
	
	public static int bool2int(boolean x) {
		 if (x)
			 return 1;
		 else
			 return 0;
	}
	

	public static void printTruthTable() {
		System.out.println("a\tb\tc\tf");
		System.out.println("0\t0\t0\t"
				+ bool2int(f(false, false, false)));
		System.out.println("0\t0\t1\t"
				+ bool2int(f(false, false, true)));
		System.out.println("0\t1\t0\t"
				+ bool2int(f(false, true, false)));
		System.out.println("0\t1\t1\t"
				+ bool2int(f(false, true, true)));
		System.out.println("1\t0\t0\t"
				+ bool2int(f(true, false, false)));
		System.out.println("1\t0\t1\t"
				+ bool2int(f(true, false, true)));
		System.out.println("1\t1\t0\t"
				+ bool2int(f(true, true, false)));
		System.out.println("1\t1\t1\t"
				+ bool2int(f(true, true, true)));

	}

	 public static void main(String arguments[]) {
		printTruthTable();
	}

}
