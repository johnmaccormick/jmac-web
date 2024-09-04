import java.util.ArrayList;

public class Teacher extends Employee {

	private String schoolName;
	private ArrayList<String> currentCourses;

	public Teacher(String name, String address, double salary) {
		super(name, address, salary);
		schoolName = null;
		currentCourses = new ArrayList<String>();
	}

	public Teacher(String name, String address, double salary,
			String schoolName) {
		super(name, address, salary);
		this.schoolName = schoolName;
		this.currentCourses = new ArrayList<String>();
	}

	public Teacher() {
		super();
	}

	public void greet() {
		System.out.println("hello");
	}

	public void doGrading() {
		// implementation omitted
	}

	public static void maybeGrade(Employee employee) {
		if (employee instanceof Teacher) {
			Teacher teacher = (Teacher) employee;
			teacher.doGrading(); // doGrading() is in Teacher but not
									// Employee
		}
	}

	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.greet(); // prints "hello", not "hi"

		Employee employee = new Teacher();
		employee.greet(); // prints "hello", not "hi"

	}

}
