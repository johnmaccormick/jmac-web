/**
 * Representation of an event in the simulation.
 */
@SuppressWarnings("unchecked")
public class Event
implements Comparable {

    private long time;
    private Object event;

    // NOTE: The eventID and nextID fields were added as a hack so that
    //       two events could be scheduled at the same time. This is 
    //       necessitated because the TreeSet on which the EventQueue is
    //       based deletes any duplicate objects (ie. those for which 
    //       compareTo returns 0.
    private long eventID;
    private static long nextID = 0;

    /** 
     * Construct a new Event that will occur at the specified time.
     *
     * @param time the time at which the event will occur.
     * @param event the Object that describes the event.
     */
    public Event(long time, Object event) {
        this.time = time;
        this.event = event;
        eventID = nextID;
        nextID++;
    }
    
    /**
     * Get the time of this Event.
     *
     * @return the time of this Event.
     */
    public long getTime() {
        return time;
    }

    /**
     * Get the Object that describes this Event.
     *
     * @return the Object describing this Event.
     */
    public Object getEvent() {
        return event;
    }

    /**
     * Specify a natural ordering for the events.  Events are ordered
     * from earliest to latest.  Ties are broken using the eventID.
     *
     * @return -1 if this Event comes before Event o. 
     *          1 if this Event comes after Event o.
     *          0 if this Event and Event o are the same Event.
     */
    public int compareTo(Object o) {
        if (this.time < ((Event)o).time) {
            return -1;
        }
        else if (this.time > ((Event)o).time) {
            return 1;
        }
        else if (this.eventID < ((Event)o).eventID) {
            return -1;
        }
        else if (this.eventID > ((Event)o).eventID) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
