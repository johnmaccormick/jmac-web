import java.util.ArrayList;

/**
 * A class that demonstrates the use of an ArrayList.
 * 
 * @author Grant Braught
 * 
 */
public class ArrayListDemo
{
    // Declare a field that can hold a reference to an 
    // ArrayList of String objects.
    private ArrayList<String> theList;
    
    /**
     * Constructor for objects of class ArrayListDemo
     */
    public ArrayListDemo()
    {
        // Construct a new ArrayList object that can hold
        // a collection of String objects and set the field
        // to refer to it.
        theList = new ArrayList<String>();
    }
    
    /**
     * Demonstrate the use of the ArrayList.
     */
    public void arrayListOperations() {
    	
        
        String str1 = "First Item";
        String str2 = "Second Item";
        String str3 = "Third Item";
        
        // Adding String objects to the ArrayList.
        theList.add(str1);
        theList.add(str2);
        theList.add(str3);
        
        // Getting and printing items from the ArrayList.
        String item = theList.get(0);
        System.out.println("Object at index 0 is " + item);
        
        // or more directly without the local variable...
        System.out.println("Object at index 1 is " + theList.get(1));
        
        // Finding the size of an ArrayList.
        int size = theList.size();
        
        System.out.println("Size is " + size);
        
        // Removing items from an ArrayList.
        theList.remove(0);
        System.out.println("Now Object at index 0 is " +theList.get(0));
        
        System.out.println("Now Size is " + theList.size());
    }
    
    public static void main(String[]margs) {
    	ArrayListDemo alDemo = new ArrayListDemo();
    	
    	alDemo.arrayListOperations();
    }
}
