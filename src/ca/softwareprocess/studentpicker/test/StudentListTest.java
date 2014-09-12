package ca.softwareprocess.studentpicker.test;

import java.util.Collection;

import ca.softwareprocess.studentpicker.Student;
import ca.softwareprocess.studentpicker.StudentList;

import junit.framework.TestCase;

public class StudentListTest extends TestCase {
	public void testEmptyStudentList() {
		StudentList studentList = new StudentList();
		Collection<Student> students = studentList.getStudents();
		assertTrue("Empty Student List", students.size() == 0);
	}
	public void testAddStudentList() {
		StudentList studentList = new StudentList();
		String studentName = "A Student";
		Student testStudent = new Student(studentName);
		studentList.addStudent(testStudent);
		Collection<Student> students = studentList.getStudents();		
		assertTrue("Student List Size", students.size() == 1);
		assertTrue("Test Student Not Contained",students.contains(testStudent));		
	}
	public void testRemoveStudent() {
		StudentList studentList = new StudentList();
		String studentName = "A Student";
		Student testStudent = new Student(studentName);
		studentList.addStudent(testStudent);
		Collection<Student> students = studentList.getStudents();		
		assertTrue("Student List Size Isn't Big Enough", students.size() == 1);
		assertTrue("",students.contains(testStudent));
		studentList.removeStudent(testStudent);
		students = studentList.getStudents();		
		assertTrue("Student List Size Isn't Small Enough", students.size() == 0);
		assertFalse("Test Student Still Contained?",students.contains(testStudent));		
		
	}
	public void testChooseStudentList() {
		StudentList studentList = new StudentList();
		String studentName = "A Student";
		Student testStudent = new Student(studentName);
		studentList.addStudent(testStudent);
		// Testing for 1 student
		for (int i = 0 ; i  < 10; i++) {
			Student student = studentList.chooseStudent();		
			assertTrue("Student is not null", student != null);
			assertTrue("Didn't choose the right student",student.equals(testStudent));
		}
		String studentNameB = "B Student";
		Student testStudentB = new Student(studentNameB);
		studentList.addStudent(testStudentB);
		Student [] studentArray = { testStudent, testStudentB };
		for (int i = 0 ; i <  studentArray.length; i++) {
			Student targetStudent = studentArray[i];
			int maxcount = 1000;
			while(maxcount > 0 && !targetStudent.equals(studentList.chooseStudent())) {
				// do nothing;			
				maxcount--;
			}
			assertTrue("Too Many iterations", maxcount > 0);
		}
	}

	
	
}
