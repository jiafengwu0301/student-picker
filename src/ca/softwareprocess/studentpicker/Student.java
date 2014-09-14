package ca.softwareprocess.studentpicker;

public class Student {
	protected String studentName;
	
	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getName() {
		return this.studentName;
	}
	
	public String toString() {
		return getName();
	}
	
}
