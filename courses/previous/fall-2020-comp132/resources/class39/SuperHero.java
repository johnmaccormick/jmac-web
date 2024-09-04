import java.util.ArrayList;
import java.util.Collections;

public class SuperHero {
	String name;
	double height; // in meters
	
	public SuperHero(String name, double height) {
		this.name = name;
		this.height = height;
	}

	
	@Override
	public String toString() {
		return "[" + name + ", height=" + height + "]";
	}

	public double getHeight() {
		return height;
	}

	public static void main(String[] args) {
		SuperHero hero1 = new SuperHero("Elektra", 1.75);
		SuperHero hero2 = new SuperHero("Storm", 1.69);
		SuperHero hero3 = new SuperHero("Gambit", 1.87);
		
		ArrayList<SuperHero> heroes = new ArrayList<>();
		heroes.add(hero1);
		heroes.add(hero2);
		heroes.add(hero3);

		System.out.println("Before sorting:");
		for (SuperHero superHero : heroes) {
			System.out.println(superHero);
		}
		
		System.out.println("\nAfter sorting:");
		//Collections.sort(heroes);
		for (SuperHero superHero : heroes) {
			System.out.println(superHero);
		}
	}

}
