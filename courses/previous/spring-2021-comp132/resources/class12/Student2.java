/**
 * An example illustrating the use of a static field for assigning
 * unique object identification numbers automatically.
 * 
 * This class assigns each student a unique student ID by using a
 * static field.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class Student2 {

    private static int nextID = 1000;
    
    private int studentID;
    private String name;
    
    /**
     * Construct a new Student2 with the given name and a unique student ID number.
     * 
     * @param name the student's name.
     */
    public Student2(String name) {
        this.name = name;
        studentID = nextID;
        nextID++;
    }
    
    /**
     * Return the ID that will be assigned to the next Student2 object
     * that is created.
     * 
     * @return the next student ID.
     */
   
    
    /**
     * Assign this Student2 a new ID.  The new ID is the next ID that 
     * is to be assigned.
     */
    
    
    /**
     * Change the ID that will be assigned to the next student.
     * 
     * @param nextID the ID to be assigned to the next student.
     */
    
    
    /**
     * Return a string representation of this Student2 object.
     * 
     * @return a string representation of this Student2.
     */
    public String toString() {
        return name + " (ID: " + studentID + ")";
    }
    
    /**
     * Create a few student objects to illustrate the use of the static field
     * for assigning unique student ID numbers.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        Student2 s1 = new Student2("Lauryn Hill");
        Student2 s2 = new Student2("Nicki Minaj");
        Student2 s3 = new Student2("MC Lyte");
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
