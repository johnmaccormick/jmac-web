/**
 * A class to represent automobiles.
 * 
 * @author Tim Wahls
 * 
 */
public class Car
{
    private String make; // the manufacturer of the Car
    private String model; // i.e. Focus, Silverado, ...
    private String color;
    private int year;
    
    /**
     * Constructor for objects of class Car.  What is the default car?
     */
    public Car()
    {
        make = "Pontiac";
        model = "Grand Prix";
        color = "green";
        year = 2000;
    }

    /**
     * change the make of the Car
     * @param mk the new make of the Car
     */
    public void setMake(String mk) {
        make = mk;
    }
 
    /**
     * change the model of the Car
     * @param mod the new model of the Car
     */
    public void setModel(String mod) {
        model = mod;
    }   
 
    /**
     * change the color of the Car
     * @param col the new color of the Car
     */
    public void setColor(String col) {
        color = col;
    }     
  
    /**
     * change the year of the Car
     * @param yr the new year of the Car
     */
    public void setYear(int yr) {
        year = yr;
    } 
    
    /**
     * display all information about the Car
     */
    public void print() {
        System.out.println("A " + color + " " + year + " " + make +
                            " " + model + ".");
    }    
  
    /**
     * return the make of the Car
     * @return the make of the Car
     */
    public String getMake() { 
        return make;
    }
  
    /**
     * return the model of the Car
     * @return the model of the Car
     */
    public String getModel() { 
        return model;
    }
  
    /**
     * return the color of the Car
     * @return the color of the Car
     */
    public String getColor() { 
        return color;
    }
  
    /**
     * return the year of the Car
     * @return the year of the Car
     */
    public int getYear() { 
        return year;
    }
    
    /**
     * return whether or not two Cars are the same
     * @return whether or not two Cars are the same
     */
    public boolean equals(Car anotherCar) { 
        return make.equals(anotherCar.make) && model.equals(anotherCar.model)
               && color.equals(anotherCar.color) && year == anotherCar.year;
    }
}
