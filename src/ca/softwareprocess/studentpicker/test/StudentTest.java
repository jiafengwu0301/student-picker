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
	public void testStudentEquals() {
		String studentName = "A Student";
		String studentNameC = "C Student";
		Student studentA = new Student(studentName);
		Student studentB = new Student(studentName);
		Student studentC = new Student(studentNameC);
		assertTrue("A!=B",studentA.equals(studentB));
		assertTrue("B!=A",studentB.equals(studentA));
		assertFalse("A==C",studentA.equals(studentC));
		assertFalse("B==C",studentB.equals(studentC));
		assertFalse("C==A",studentC.equals(studentA));
		assertTrue("A==A",studentA.equals(studentA));
		assertTrue("B==B",studentB.equals(studentB));
		assertTrue("C==C",studentC.equals(studentC));		
		assertTrue("A==(Object)B",studentA.equals((Object)studentB));
	}
}
