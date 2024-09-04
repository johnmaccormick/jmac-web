
public class Duck implements MakesSound {

	private String species;
    
    public Duck() {
        this.species = "unknown";
    }

    public Duck(String species) {
        this.species = species;
    }
    
    public String getSpecies() {
        return species;
    }
	
	public int getNumWings() {
		return 2;
	}

	/////////////////////////////////////////////////////////////////////
	// implementation of the MakesSound interface
	public void makeSound() {
		System.out.println("Quack, Quack");
	}

	public int howLoud() {
		return 4;
	}
	// end of MakesSound interface
	/////////////////////////////////////////////////////////////////////

	
	
	public static boolean isDuck(MakesSound m) {
		if (m instanceof Duck) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		MakesSound duck = new Duck();
		MakesSound sheep = new Sheep();

		System.out.println(isDuck(duck));
		System.out.println(isDuck(sheep));
		
	}

}
