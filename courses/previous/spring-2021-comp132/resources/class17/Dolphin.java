/**
 * The Dolphin class implements both the MakesSound and Swims interfaces.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class Dolphin implements MakesSound, Swims, Comparable<Dolphin> {

    private int length; // in feet.

    public Dolphin(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    // === Implementation of the MakesSound interface (two methods below) ===

    public void produceSound() {
        System.out.println("Squeek Squeek");
    }

    public int howLoud() {
        return 2;
    }

    // === Implementation of the Swims interface (one method below) ===

    public void swim() {
        System.out.println("Shaking my tail, Shaking my tail");
    }

    // === Implementation of the Comparable interface 

    /**
     * Implementation of the compareTo method specified by the Comparable
     * interface.
     * 
     * <p>
     * This method returns:
     * <UL>
     * <LI>a positive value (+1) if this Dolphin is longer than dol (i.e. comes
     * after it in sorted order.)
     * <LI>0 if this Dolphin and dol have the same length
     * <LI>a negative value (-1) if this Dolphin is shorter than dol (i.e. comes
     * after it in sorted order.)
     * </UL>
     */
    public int compareTo(Dolphin dol) {
        if (this.getLength() > dol.getLength()) {
            return +1;  // this dolphin is longer than dol.
        }
        else if (this.getLength() == dol.getLength()) {
            return 0;   // this dolphin is the same length as dol.
        }
        else {
            return -1;  // this dolphin is shorter than dol
        }
    }
}
