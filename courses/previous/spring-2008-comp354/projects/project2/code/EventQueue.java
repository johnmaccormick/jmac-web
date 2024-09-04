import java.util.*;

/**
 * A TreeSet that holds and orders the pending Events.
 */
@SuppressWarnings({ "serial", "unchecked" })
public class EventQueue
extends TreeSet {

    /**
     * Add an Event to this EventQueue.
     *
     * @param o the Event to be added.
     */
    public void addEvent(Event o) {
        super.add(o);
    }

    /**
     * Get the next Event from this EventQueue.
     * 
     * @return the next event or null if there are no pending events.
     */
    public Event getNextEvent() {
        try {
            return (Event)super.first();
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
    
    /**
     * Remove the next Event from from this EventQueue.
     *
     * @return the next event or null if there are no pending events.
     */
    public Event removeNextEvent() {
        try {
            Event e = getNextEvent();
            super.remove(super.first());
            return e;
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
    
    /**
     * Dump this EventQueue to the screen for debugging purposes.
     */ 
    @SuppressWarnings("unchecked")
	public void printEventQueue() {
        Iterator it = iterator();
        while(it.hasNext()) {
            Event e = (Event)it.next();
            System.out.println(e.getTime() + ": " + e.getEvent());
        }
    }
}
