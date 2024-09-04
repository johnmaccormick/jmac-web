/**
 * Each process will have a ProcessControlBlock. The ProcessControlBlock for a
 * process will move between the ready queue and the device queues based on the
 * system calls and interrupts received.
 * 
 * The ProcessControlBlock is where you'll want to keep the information that you
 * need to compute statistics such as turnaround time, wait time, waiting time
 * and response time.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Mar 4, 2005
 */
class ProcessControlBlock {

    protected String name;

    public ProcessControlBlock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
