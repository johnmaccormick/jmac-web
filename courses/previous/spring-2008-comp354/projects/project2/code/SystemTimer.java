
import java.util.*;

public class SystemTimer {

    /**
     * Number of virtual time units allocated to the processing of a system
     * call.
     */
    public static final int SYSCALL_TIME = 2;
    
    public static final boolean debug = false;

    private Kernel osKernel;

    @SuppressWarnings("unchecked")
	private Vector processes;

    private EventQueue events;

    @SuppressWarnings("unchecked")
	private Hashtable deviceTimes;

    private long kernelTime;

    private long systemTime;

    private long idleTime;
    
    private long userTime;

    private Event currentTimerEvent;

    private Process idleProcess;

    /**
     * Construct a new SystemTimer object.
     * 
     * @param processes the Vector of processes that this timer will be
     *            simulating.
     * @param events the EventQueue that holds the events scheduled in the
     *            system.
     */
    @SuppressWarnings("unchecked")
	public SystemTimer(Vector processes, EventQueue events) {
        this.processes = processes;
        this.events = events;
        deviceTimes = new Hashtable();

        idleProcess = new Process("IDLE", 0, null);

        kernelTime = 0;
        userTime = 0;
        systemTime = 0;
        idleTime = 0;
    }

    /**
     * Set the Kernel object to which this SystemDriver will issue its
     * interrupts and system calls.
     * 
     * @param kernel the Kernel object.
     */
    public void setKernel(Kernel kernel) {
        osKernel = kernel;
    }

    public void processEvents() {

        // while not done
        //   handle any events scheduled for at or before the current time.
        //     (Events are start process or I/O interrupt)
        //     advance the system time as appropriate
        //
        //   increment the system time
        //   credit 1 time unit to the running process
        //
        //   if process cpu burst is done
        //      issue the process' request for I/O or termination
        //      advance the system time as appropriate

        while (!simulationFinished()) {
            Event nextEvent = events.getNextEvent();
            while (nextEvent != null && nextEvent.getTime() <= systemTime) {
                processEvent(events.removeNextEvent());
                nextEvent = events.getNextEvent();
            }
            
            String runningProcName = osKernel.running(this);
            Process runningProc = getProcess(runningProcName);
            
            if (debug) {
                /*
                 * Note: The system time reported by this debugging statement
                 * is the time at the start of a time slice.  So for example:
                 * ...
                 * 23		running Process1 
                 * 24 	running Process2
                 * ...
                 * means that Process1 runs from time 23 to time 24 and
                 * that Process2 begins running at time 24 and runs through
                 * at least time 25.
                 */
                System.out.println(systemTime + "\t\trunning " + runningProc.getName());
            }
            
            creditProcess(runningProc);
        }
        
        osKernel.terminate(this);
    }

    /*
     * Handle the crediting of a CPU time unit to a process. If it is the idle
     * process just up the idle time. If it is another process credit it with 1
     * unit of CPU time and then check to see if the current CPU burst has
     * completed. If it has then generate a system call for the process. The
     * system call will either be an I/O request or a termination request.
     */
    private void creditProcess(Process proc) {

        if (proc.getName().equalsIgnoreCase("IDLE")) {
            idleTime++;
            systemTime++;
        }
        else {
            ProcessOperation pOp = proc.getOp();
            int theOp = pOp.getOpType();
            if (theOp == ProcessOperation.CPU) {
                proc.execute(1);
                userTime++;
                systemTime++;
                
                if (proc.getCPUBurstRemaining() == 0) {
                    generateSystemCall(proc);
                }
            }
            else {
                throw new RuntimeException("Process (" + proc.getName()
                        + ") reported as running by kernel is "
                        + "not runnable!.  It is currently waiting "
                        + "or has already exited.");
            }
        }
    }

    /*
     * The process generated a system call. Figure out what type of system call
     * it was and issue the call to the kernel. If the system call is an I/O
     * request then this method will put an event into the queue for the
     * interrupt that is issued when the I/O is complete. If it is one of the
     * other types of interrupts then the system call is just passed along to
     * the kernel.
     */
    @SuppressWarnings("unchecked")
	private void generateSystemCall(Process proc) {
        
        ProcessOperation pOp = proc.getOp();
        int theOp = pOp.getOpType();

        if (theOp == ProcessOperation.IO) {

            if (debug) {
                System.out.println(systemTime + "\t\thandling IO System Call (" + 
                        pOp.getOpDevice() + ")");
            }
            
            // Look up the device for the operation in the hash table
            // if it exists compute the new free time for the device
            // and put an entry for the device back into the
            // hash table.
            Long freeAt = (Long) deviceTimes.remove(pOp.getOpDevice());
            long freeTime;
            if (freeAt != null) {
                freeTime = freeAt.longValue();

                // If the device is not currently free add the time
                // of the new op to the free time of the device.
                if (freeTime > systemTime + SYSCALL_TIME) {
                    freeTime = freeTime + pOp.getOpTime();
                }
                else if (freeTime > systemTime) {
                    freeTime = freeTime + pOp.getOpTime() +
                    (systemTime + SYSCALL_TIME - freeTime);
                }
                // If the device is currently free it will be free
                // again after this operation is complete.
                else {
                    freeTime = systemTime + pOp.getOpTime() + SYSCALL_TIME;
                }
            }
            else {
                // There was not yet an entry for this device so
                // it will be free again after this operation is
                // complete.
                freeTime = systemTime + pOp.getOpTime() + SYSCALL_TIME;
            }
            
            deviceTimes.put(pOp.getOpDevice(), new Long(freeTime));
            events.addEvent(new Event(freeTime, pOp));

            osKernel.systemCall(Kernel.IO_REQUEST, pOp.getOpDevice(), this);
            kernelTime = kernelTime + SYSCALL_TIME;
            systemTime = systemTime + SYSCALL_TIME;
        }
//        else if (theOp == ProcessOperation.WAIT) {
//            osKernel.systemCall(Kernel.WAIT, pOp.getOpDevice());
//        }
//        else if (theOp == ProcessOperation.NOTIFY) {
//            osKernel.systemCall(Kernel.NOTIFY, pOp.getOpDevice());
//        }
//        else if (theOp == ProcessOperation.NOTIFY_ALL) {
//            osKernel.systemCall(Kernel.NOTIFY_ALL, pOp.getOpDevice());
//        }
        else if (theOp == ProcessOperation.EXIT) {
            
            if (debug) {
                System.out.println(systemTime + "\t\thandling EXIT System Call");
            }
            
            osKernel.systemCall(Kernel.TERMINATE_PROCESS, null, this);
            kernelTime = kernelTime + SYSCALL_TIME;
            systemTime = systemTime + SYSCALL_TIME;
        }
        else {
            throw new RuntimeException("SystemTimer.generateSystemCall() "
                    + "should not be handling: " + pOp);
        }
    }

    /*
     * Process an event scheduled for the current time or earlier. Events can be
     * a new process starting or an interrupt genereated by a hardware device.
     */
    private void processEvent(Event e) {
                
        if (e.getEvent() instanceof String) {
            
            if (debug) {
                System.out.println(systemTime + "\t\tprocessing interrupt from (" +
                        e.getEvent() + ")");
            }
            
            osKernel.interrupt((String) e.getEvent(), this);
            kernelTime = kernelTime + SYSCALL_TIME;
            systemTime = systemTime + SYSCALL_TIME;
        }
        else if (e.getEvent() instanceof ProcessOperation) {
            ProcessOperation pOp = (ProcessOperation) (e.getEvent());
            int theOp = pOp.getOpType();

            if (theOp == ProcessOperation.START) {
                
                if (debug) {
                    System.out.println(systemTime + "\t\tStarting Process (" +
                            pOp.getParent().getName() + ")");
                }
                
                osKernel.systemCall(Kernel.START_PROCESS, pOp.getParent()
                        .getName(), this);
                kernelTime = kernelTime + SYSCALL_TIME;
                systemTime = systemTime + SYSCALL_TIME;
            }
            else if (theOp == ProcessOperation.IO) {
                
                if (debug) {
                    System.out.println(systemTime + "\t\tprocessing interrupt from (" +
                            pOp.getOpDevice() + ")");
                }
                
                osKernel.interrupt(pOp.getOpDevice(), this);
                kernelTime = kernelTime + SYSCALL_TIME;
                systemTime = systemTime + SYSCALL_TIME;
                
                pOp.getParent().advanceOpCounter();
            }
            else {
                throw new RuntimeException("Event " + pOp + " should not "
                        + "have been found in the event queue.");
            }
        }
        else {
            throw new RuntimeException("Unrecognized Event " + e
                    + " has been found in the event queue.");
        }
    }

    /*
     * Get the Process object corresponding to the process name.
     */
    private Process getProcess(String procName) {
        // Make a phony Process object for the purposes of
        // searching for the original Process object corresponding
        // to the name.
        Process proc = new Process(procName, 0, null);
        int procIndex = processes.indexOf(proc);

        // Make sure the kernel reported a valid process...
        if (procIndex != -1) {
            // Get the real Process object and process it.
            proc = (Process) processes.get(procIndex);
            return proc;
        }
        else if (procName.equalsIgnoreCase("IDLE")) {
            return idleProcess;
        }
        else {
            throw new RuntimeException("Process (" + procName
                    + ") reported as running by " + "kernel does not exist.");
        }
    }

    /*
     * Determine if the simulation has concluded.
     */
    @SuppressWarnings("unchecked")
	private boolean simulationFinished() {
        // Put the termination condition here.
        // probably that all of the processes have reached their termination

        // Also need a way to bail if the simulation isn't making progress.
        // E.g. for some reason the scheduler isn't running the ready processes.

        boolean allDone = true;
        Iterator pit = processes.iterator();
        while (pit.hasNext()) {
            Process p = (Process) pit.next();
            allDone = allDone && p.finished();
        }

        return allDone;
    }

    /**
     * Schedule a timer interrupt to occur after the specified number of time
     * units. The timer is set to begin when the system call that started it
     * completes. Thus a process started to run when a timer is set will be
     * allowed to run for a full "delay" time units.
     * Only one timer interrupt can be scheduled at a time. If the event
     * queue already contains a timer interrupt that timer interrupt will be
     * canceled and a new one created.
     * 
     * @param delay the number of time units before the timer interrupt will
     *            occur.
     */
    public void scheduleTimerInterrupt(int delay) {
        cancelTimerInterrupt();
        currentTimerEvent = new Event(systemTime + delay + SYSCALL_TIME, "TIMER");
        events.addEvent(currentTimerEvent);
    }

    /**
     * Get the amount of time remaining before the currently set timer interrupt
     * occurs. If no timer interrupt is currently pending, then the value -1 will
     * be returned.
     *
     * @return the number of time units before the currently pending timer interrupt
     * will occur, or -1 if no timer interrupt is pending.
     */
    public int getTimerTicksRemaining() {
        if (currentTimerEvent != null) {
            long timerTime = currentTimerEvent.getTime();
            if (timerTime >= systemTime) {
                return (int)(timerTime - systemTime);
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    /**
     * Cancel a timer interrupt if one has been set. If a timer interrupt has
     * been set, it is removed from the event queue. If no timer interrupt has
     * been set this method does nothing.
     */
    public void cancelTimerInterrupt() {
        // Remove any timer interrupt that appears in the event queue.
        if (currentTimerEvent != null) {
            events.remove(currentTimerEvent);
            currentTimerEvent = null;
        }
    }

    /**
     * Return the current kernel time. This is the number of virtual time units
     * that the system has spent performing kernel operations.
     * 
     * @return the current kernel time.
     */
    public long getKernelTime() {
        return kernelTime;
    }

    /**
     * Return the current user time. This is the number of virtual time units
     * that the system has spent performing user operations.
     * 
     * @return the current user time.
     */
    public long getUserTime() {
        return userTime;
    }

    /**
     * Return the current idle time. This is the number of virtual time units
     * that the system has spent executing the idle process.
     * 
     * @return the current idle time.
     */
    public long getIdleTime() {
        return idleTime;
    }

    /**
     * Return the current system time. This is the total number of virtual time
     * units that have elapsed since the system has started. It should agree
     * with the value obtained from getKernelTime() + getUserTime() +
     * getIdleTime();
     * 
     * @return the current system time.
     */
    public long getSystemTime() {
        return systemTime;
    }
}

