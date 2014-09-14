package ca.softwareprocess.studentpicker.test;

import junit.framework.TestCase;
import ca.softwareprocess.studentpicker.Student;

public class StudentTest extends TestCase {
	public void testStudent() {
		String studentName = "A Student";
		Student student = new Student(studentName);
		assertTrue("Student Name is not equal", studentName.equals(student.getName()));		
	}
	public void testStudentToString() {
		String studentName = "A Student";
		Student student = new Student(studentName);		
		assertTrue("Student Name.toString is not equal", studentName.toString().equals(student.getName()));
	}
}
