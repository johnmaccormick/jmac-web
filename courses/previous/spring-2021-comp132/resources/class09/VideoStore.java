import java.util.ArrayList;

/**
 * This class models a VideoStore as a collection
 * of DVDs.  The VideoStore class has two fields.  One
 * is a String indicating the name of the Video Store.
 * The other is an ArrayList that holds a collection of
 * DVD objects representing all of the videos in the 
 * store's collection.
 * 
 * @author Grant Braught
 *
 */
public class VideoStore
{
    private String storeName;
    private ArrayList<DVD> dvdList;
    
    /**
     * Construct a new VideoStore with the specified name.
     * Initially the VideoStore does not contain any DVDs.
     * 
     * @param initName the name of this VideoStore.
     */
    public VideoStore(String initName) {
        storeName = initName;
        dvdList = new ArrayList<DVD>();
    }
    
    /**
     * Get the name of this VideoStore.
     * 
     * @return the name of this VideoStore.
     */
    public String getStoreName() {
        return storeName;
    }
    
    /**
     * Get the number of DVDs that are in this
     * VideoStore's collection.
     * 
     * @return the number of DVDs in this VideoStore.
     */
    public int getNumDVDs() {
        return dvdList.size();
    }

    /**
     * Add a new DVD to the DVD collection of this
     * VideoStore.
     * 
     * @param newDVD the DVD to be added.
     */
    public void addDVD(DVD newDVD) {
        dvdList.add(newDVD);
    }
    
    /**
     * Remove from the collection the DVD at the indicated position.
     * This method checks that the indicated position is valid.
     * If the position is valid, the DVD is removed.  If the position 
     * is not valid (either negative or too large) an error message 
     * is printed.
     * 
     * @param position the index of the DVD to remove.
     */
    public void removeDVD(int index) {
        if (index >= 0 && index < dvdList.size()) {
            dvdList.remove(index);
        }
        else {
            System.out.println("Error: No DVD at index " + index + ".");
        }
    }
    
    /**
     * Print the DVD at the indicated position in the DVD collection of this VideoStore.
     * This method checks that the indicated position is valid.
     * If the position is valid, the description of the DVD is
     * printed.  If the position is not valid (either negative or
     * too large) an error message is printed.
     * 
     * @param position the index of the DVD to print.
     */
    public void printDVD(int index) {
        // Add your code here.
    }
    
    
    /**
     * Print the title of the DVD at the indicated
     * position in the DVD collection of this VideoStore.
     * This method checks that the indicated position is valid.
     * If the position is valid, the description of the DVD is
     * printed.  If the position is not valid (either negative or
     * too large) an error message is printed.
     * 
     * @param position the index of the DVD to print.
     */
    public void printDVDTitle(int index) {
        // Add your code here.
    }
    
    /**
     * Get the DVD at the specified index in the collection.
     * This method checks that the indicated index is valid.
     * If the index is valid, the DVD is returned.  If the index 
     * is not valid (either negative or too large) an error message 
     * is printed.
     * 
     * @param index the index from which to get the DVD.
     * @return the DVD at the specified index or null if the
     * index is not valid.
     */
    public DVD getDVD(int index) {
        if (index >= 0 && index < dvdList.size()) {
            DVD dvd = dvdList.get(index);
            return dvd;
        }
        else {
            System.out.println("Error: No DVD at index " + index + ".");
            return null;
        }
    }
   
    /**
     * Move the DVD at the specified index to the end of the collection.  If the
     * specified index is not valid then this method prints an error message and
     * the collection is not modified.
     * 
     * @param the index of the DVD to be moved.
     */
    public void moveDVDToEnd(int index) {
        // Add your code here.
    }
    
    /**
     * Get the DVD at the specified index if it is not currently out on rental. 
     * If the DVD is not in stock then a message indicating that the DVD is currently 
     * rented is displayed and this method returns null.
     * If the index is not valid (either negative or too large) an error message 
     * is printed and this method returns null.
     * 
     * @param index the index from which to get the DVD.
     * @return the DVD at the specified index or null.
     */
    public DVD getDVDIfInStock(int index) {
        // Replace with your code.
        return null;
    }
    
    /**
     * Print all of the DVD's in this VideoStore's collection.
     */
    public void printAllDVDs() {
        for (int d=0; d < dvdList.size(); d++) {
            DVD dvd = dvdList.get(d);
            System.out.println(dvd.toString());
        }
    }
    
    /**
     * Print all of the DVD's in this VideoStore's collection in revsere 
     * order.
     */
    public void revPrintAllDVDs() {
        // Add your code here.
    }
    
    /**
     * Print just the titles of all of the DVD's in this VideoStore's
     * collection.
     */
    public void printTitleList() {
        // Add your code here.
    }
    
    /**
     * Find and return the total number of rental nights
     * on all of the DVD's in this VideoStore's collection.
     * 
     * @return the total number of rental nights.
     */
    public int countRentalNights() {
        int count = 0;
        for (int d=0; d < dvdList.size(); d++) {
            DVD dvd = dvdList.get(d);
            count = count + dvd.getNightsRented();
        }
        return count;
    }
    
    /**
     * Get the number of overdue DVDs in the store.
     * 
     * @return the number of overdue DVDs.
     */
    public int countOverdueDVDs() {
        // Replace with your code.
        return 0;
    }
    
    /**
     * Count the number of DVD's that are assumed to be lost.
     * Assume that any DVD that is overdue by more than the specified
     * number of nights has been lost.
     * 
     * @param nights the specified number of nights.
     */
    public int countLostDVDs(int nights) {
        // Replace with your code.
        return 0;
    }
    
    /**
     * Count and return the number of DVDs that are currently
     * in stock.  That is, the have been out on rental for 0
     * nights.
     * 
     * @return the number of in stock titles.
     */
    public int countInStockTitles() {
        // Replace with your code.
        return 0;
    }
    
    /**
     * Increase the number of rental nights on each rented
     * DVD by 1 night.
     */
    public void increaseRentalNights() {    
        for (int d=0; d < dvdList.size(); d++) {
            DVD dvd = dvdList.get(d);
            dvd.addRentalNight();
        }
    }
    
    /**
     * Find and return the DVD that has been rented for the longest
     * period of time. If multiple DVDs tie for the longest rental, return
     * the first one. If no DVDs have been rented or there are no DVD's 
     * in the store then this method returns null.
     * 
     * @return the DVD with the most rental nights, or null if the
     * store contains no DVDs.
     */
    public DVD getLongestRental() {
        if  (dvdList.size() != 0) {
            DVD longest = dvdList.get(0);
            for (int d=1; d < dvdList.size(); d++) {
                DVD dvd = dvdList.get(d);
                if (dvd.getNightsRented() > longest.getNightsRented()) {
                    longest = dvd;
                }
            }
            return longest;
        }
        else {
            return null;
        }
    }
    
    /**
     * Increase the number of nights that every DVD can be rented by
     * the specified amount.
     * 
     * @param nights the number of nights by which to increase the
     * rental lengths.
     */
    public void increaseRentalLengths(int nights) {
        // Add your code here.
    }
    
    /**
     * Get the DVD that is the most overdue. If multiple DVD's tie for the
     * most overdue, return the first one.  If there are no overdue
     * DVDs then return null.
     * 
     * @return the most overdue DVD, or null if there are no overdue
     * DVDs.
     */
    public DVD getMostOverdueDVD() {
        // Replace with your code.
        return null;
    }
    
    /**
     * Print a list of all of the DVD's in the VideoStore's collection
     * in the reverse of the order in which they are stored.
     */
    public void printAllDVDsWithWhile() {
        int d=0;
        while (d < dvdList.size()) {
            DVD dvd = dvdList.get(d);
            System.out.println(dvd.toString());
            d++;
        }
    }
    
    /**
     * Get the first overdue DVD.  If there are no overdue DVD's then this
     * method returns null.
     * 
     * @return the first overdue DVD or null if there are no overdue DVDs.
     */
    public DVD getFirstOverdueDVD() {
        int d=0;
        DVD overdue = null;
        while (d < dvdList.size() && overdue == null) {
            DVD dvd = dvdList.get(d);
            if (dvd.isOverdue()) {
                overdue = dvd;
            }
            else {
                d++;
            }
        }
        return overdue;
    }
    
    /**
     * Get the first DVD with the rating specified by the parameter.  If there are no 
     * DVD's with the specified rating then this method returns null.
     * 
     * @param rating the specified rating.
     * @return the first DVD with the rating or null if there are none.
     */
    public DVD getFirstDVDWithRating(String rating) {
        // Replace with your code.
        return null;
    }
    
    /**
     * Get the last DVD in the collection that is currently in stock.  If there
     * are no DVD's in stock then this method returns null.
     * 
     * @return the last DVD in stock or null if there are none.
     */
    public DVD getLastDVDInStock() {
        // Replace with your code.
        return null;
    }
    
    /**
     * Find all of the DVDs with the specified rating and 
     * return them in a new VideoStore.   The name of the returned
     * VideoStore will be "? Rated DVDs" where ? is the specified rating.
     * If there are no DVDs with the specified rating then an empty 
     * VideoStore is returned.
     * 
     * @return a new VideoStore holding all DVDs with the specified
     * rating.
     * 
     *  !!! BEWARE -- this method contains a deliberate error !!!
     */
    public VideoStore getAllDVDsWithRating(String rating) {
        String storeName = rating + " RatedDVDs";
        VideoStore withRating = new VideoStore(storeName);
        for (int d=0; d < dvdList.size(); d++) {
            DVD dvd = dvdList.get(d);
            String curRating = dvd.getRating();
            if (curRating == rating) {
                withRating.addDVD(dvd);
            }
        }
        
        return withRating;
    }

    /**
     * Find all of the DVDs that are overdue and return them in a new VideoStore object. 
     * The name of the returned VideoStore will be "Overdue DVDs". If there are
     * no DVDs that are overdue then this method returns an empty VideoStore object.
     * 
     * @return a new VideoStore object holding all overdue DVDs.
     */
    public VideoStore getAllOverdueDVDs() {
    	// create a new, empty video store
    	VideoStore newStore = new VideoStore("Overdue DVDs");
    	// add overdue DVDs to the new store
    	for (int d = 0; d < dvdList.size(); d++) {
    		DVD dvd = dvdList.get(d);
    		if ( dvd.isOverdue() ) {
    			newStore.addDVD(dvd);
    		}
    	}
    	// return the new store
    	return newStore;
    }
    
    /**
     * Find all of the DVDs that are overdue by at least a specified number
     * of nights and return them in a new VideoStore object. 
     * The name of the returned VideoStore will be "Overdue > ? nights" where 
     * ? is the specified number of nights .If there are
     * no DVDs that are overdue by at least the specified number of nights then
     * this method returns an empty VideoStore object.
     * 
     * @param nights the specified number of nights.
     * @return a new VideoStore holding all DVDs that are overdue by 
     * at least the specified number of nights.
     */
    public VideoStore getMoreOverdueThan(int nights) {
        // Replace with your code.
        return null;
    }
    
    public static void main (String[] args) {
    	DVD dvd1 = new DVD("Fantastic Mr. Fox", "PG", 7);
    	DVD dvd2 = new DVD("Isle of Dogs", "PG-13", 7);
    	DVD dvd3 = new DVD("Avengers: Infinity War", "PG-13", 2);
    	
    	VideoStore store = new VideoStore("COMP132 Movies");
    	
    	store.addDVD(dvd1);
    	store.addDVD(dvd2);
    	store.addDVD(dvd3);
    	
    }
    
}
