package ca.softwareprocess.studentpicker.test;

import java.util.Collection;

import ca.softwareprocess.studentpicker.EmptyStudentListException;
import ca.softwareprocess.studentpicker.Student;
import ca.softwareprocess.studentpicker.StudentList;

import junit.framework.TestCase;

public class StudentListTest extends TestCase {
	public void testEmptyStudentList() {
		StudentList studentList = new StudentList();
		assertTrue("Empty Student List", studentList.size() == 0);
	}
	public void testAddStudentList() {
		StudentList studentList = new StudentList();
		String studentName = "A Student";
		Student testStudent = new Student(studentName);
		studentList.addStudent(testStudent);			
		assertTrue("Student List Size", studentList.size() == 1);
		assertTrue("Test Student Not Contained",studentList.contains(testStudent));		
	}
	public void testGetStudents() {
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
		assertTrue("Student List Size Isn't Big Enough", studentList.size() == 1);
		assertTrue("",studentList.contains(testStudent));
		studentList.removeStudent(testStudent);		
		assertTrue("Student List Size Isn't Small Enough", studentList.size() == 0);
		assertFalse("Test Student Still Contained?",studentList.contains(testStudent));		
		
	}
	public void testChooseStudentList() {
		try {
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
		} catch (EmptyStudentListException e) {
			assertTrue("EmptyStudentListException was thrown!"+e, false);			
		}
	}
	public void testChooseEmptyStudentList() {
		StudentList studentList = new StudentList();
		try {
			Student s = studentList.chooseStudent();
			assertFalse("We shouldn't reach here",s==null);
			assertTrue("We shouldn't reach here",false);
		} catch (EmptyStudentListException e) {
			assertTrue("We should reach here",true);
		}
		
	}
	
	
}
