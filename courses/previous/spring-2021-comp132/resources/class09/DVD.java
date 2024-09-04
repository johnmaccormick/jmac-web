/**
 * This class represents a DVD that is for rent
 * in a video store. The DVD has a title, an 
 * MPAA rating (e.g. "G", "PG", "R", a length of 
 * time that it can be rented for (e.g. a 5 night rental) 
 * and the number of nights that it has been out on
 * rental (e.g. if it was rented yesterday then it
 * has been out 1 night so far).
 * 
 * @author Grant Braught
 * 
 */
public class DVD
{
    private String title;
    private String mpaaRating;
    private int rentalLength;
    private int nightsRented;
    
    /**
     * Create a new DVD with the specified title, MPAA rating and
     * number of nights for which the DVD can be rented.
     * Initially, the DVD is not rented and thus the number
     * of nights that it has been out on rental should be 0.
     * 
     * @param initTitle the title of the DVD.
     * @param initRating the MPAA rating for the movie.
     * @param initLength the number of nights for which 
     * the DVD can be rented.
     */
    public DVD(String initTitle, String initRating, int initLength) {
        title = initTitle;
        // next line calls the String constructor explicitly,
        // for technical reasons -- it will help us demonstrate the
        // difference between == and equals()
        mpaaRating = new String(initRating);
        rentalLength = initLength;
        nightsRented = 0;
    }

   /**
    * Get the title of this DVD.
    * 
    * @return the title of this DVD.
    */
   public String getTitle() {
       return title;
   }
    
    /**
     * Get the number of nights that this DVD 
     * can be rented for.
     * 
     * @return the length of rental for this DVD in nights.
     */
    public int getRentalLength() {
        return rentalLength;
    }
    
    /**
     * Get the MPAA rating for this DVD.
     * 
     * @return the MPAA rating.
     */
    public String getRating() {
        return mpaaRating;
    }
    
    /**
     * Get the number of nights for which this DVD
     * has currently been rented.
     * 
     * @return the number of nights this DVD has been rented out.
     */
    public int getNightsRented() {
        return nightsRented;
    }
    
    /**
     * Add one to the number of nights that this DVD
     * had been out on rental.
     */
    public void addRentalNight() {
        nightsRented = nightsRented + 1;
    }
    
    /**
     * Return this DVD to the store.  Effectively this
     * sets the number of nights that it has been rented
     * back to 0.
     */
    public void returnDVD() {
        nightsRented = 0;
    }
    
    /**
     * Determine if this DVD is overdue.  Return true
     * if this DVD has been kept longer than the number
     * of nights for which it is allowed to be rented.
     * 
     * @return true if this DVD is overdue and false otherwise.
     */
    public boolean isOverdue() {
        return nightsRented > rentalLength;
    }
    
    /**
     * Set the number of nights that this DVD can be rented.
     * 
     * @param nights the number of nights.
     */
    public void setRentalLength(int nights) {
        rentalLength = nights;
    }
    
    /**
     * Get a String describing this DVD. The String representation
     * will have the format:
     * <pre><code>
     *         Title: Wierd Science
     *   MPAA Rating: PG
     * Rental Nights: 5
     *    Nights Out: 0
     * </code></pre>
     * 
     * @return a String describing this DVD.
     */
    public String toString() {
        String str = "";
        
        str = str + "        Title: " + title + "\n";
        str = str + "  MPAA Rating: " + mpaaRating + "\n";
        str = str + "Rental Nights: " + rentalLength + "\n";
        str = str + "   Nights Out: " + nightsRented + "\n";

        return str;
    }
}
