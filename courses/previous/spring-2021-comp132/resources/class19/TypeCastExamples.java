
public class TypeCastExamples {

	public static MakesSound whoIsLouder(MakesSound obj1, MakesSound obj2) {
		if (obj1.howLoud() >= obj2.howLoud()) {
			return obj1;
		} else {
			return obj2;
		}
	}	
	
	public static void main(String[] args) {
		Duck duck = new Duck("Fulvous Whistling-Duck");
		Dolphin dolphin = new Dolphin(9);
				
		MakesSound louder = whoIsLouder(duck, dolphin);
	
		System.out.println(louder);
	
//		String species = louder.getSpecies();
//		System.out.println(species);

		
//		primitiveCasts();
	}
	
	public static void primitiveCasts() {
		double x = 5.67;
		int y = (int) x;
		
		System.out.println("x = " + x + ", y = " + y);
		
		// better, usually
		long z = Math.round(x);
		
	}
}
