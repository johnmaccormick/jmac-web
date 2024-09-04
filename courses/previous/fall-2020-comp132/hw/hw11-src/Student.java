/**
 * Student object used for the java sorting examples. Students are naturally
 * ordered by their idNumber.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui and John
 * MacCormick
 * @author Dickinson College
 * @version June, 2020
 */
public class Student implements Comparable<Student> {
    private int idNumber;
    private String name;
    private int gradYear;
    private double gpa;

    /**
     * Construct a new Student.
     * 
     * @param id the student's id number
     * @param name the student's name
     * @param year the student's graduation year
     * @param gpa the student's gpa
     */
    public Student(int id, String name, int year, double gpa) {
        idNumber = id;
        this.name = name;
        gradYear = year;
        this.gpa = gpa;
    }

    /**
     * Check if this Student has the same id number as the provided student.
     * 
     * @param stu the Student to compare to this one.
     * @return true if this student has the same id number as stu and false
     *         otherwise.
     */
    public boolean equals(Student stu) {
        return idNumber == stu.getIdNumber();
    }
    
    /**
     * This method defines the natural ordering of Student objects to be by id
     * number.
     * 
     * @param stu the Student to which this one is compared.
     * @return -1 if this student comes before stu, 1 if this student comes
     *         after stu, and 0 if they have the same id.
     */
    public int compareTo(Student stu) {
//        if (this.equals(stu)) {
//            return 0;
//        }
//        else if (idNumber < stu.getIdNumber()) {
//            return -1;
//        }
//        else {
//            return 1;
//        }
    	if (gradYear < stu.getGradYear()) {
    		return -1;
    		}
    		else if (gradYear > stu.getGradYear()) {
    		return 1;
    		}
    		else {
    		return 0;
    		}

    }

    // Other accessors below.  Javadoc omitted for brevity.

    public String toString() {
        return idNumber + ": " + name + " : " + gradYear + " : " + gpa;
    }

    public int getGradYear() {
        return gradYear;
    }

    public double getGpa() {
        return gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }
}
