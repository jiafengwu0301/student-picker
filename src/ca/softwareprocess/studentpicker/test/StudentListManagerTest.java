package ca.softwareprocess.studentpicker.test;

import java.io.IOException;

import ca.softwareprocess.studentpicker.EmptyStudentListException;
import ca.softwareprocess.studentpicker.Student;
import ca.softwareprocess.studentpicker.StudentList;
import ca.softwareprocess.studentpicker.StudentListManager;
import android.test.AndroidTestCase;

public class StudentListManagerTest extends AndroidTestCase {
	public void testStudentToString() {
		StudentList sl = new StudentList();
		Student testStudent = new Student("TestStudent");
		sl.addStudent(testStudent);
		try {
			String str = StudentListManager.studentListToString(sl);
			assertTrue("String is too small ",str.length() > 0);
			StudentList sl2 = StudentListManager.studentListFromString(str);
			assertTrue("Sl2 size > 0", sl2.size() > 0);
			assertTrue("Chosen student doesn't have same name", sl2.chooseStudent().toString().equals(testStudent.getName()));
			assertTrue("Chosen student doesn't have same name", sl2.chooseStudent().equals(testStudent));
			assertTrue("TestStudent!=sl2's testStudent", sl2.chooseStudent()!=testStudent);
			assertTrue("Collection Containment", sl2.getStudents().contains(testStudent));
			assertTrue("Sl does not contain testStudent",sl.contains(testStudent));
			assertTrue("Sl2 does not contain testStudent",sl2.contains(testStudent));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue("IOEXception "+e,false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue("CLassNotFoundException "+e,false);
		} catch (EmptyStudentListException e) { 
			e.printStackTrace();
			assertTrue("EmptyStudentListException "+e,false);
		}		
	}
	public void testStudentListManager() {
		try {
			StudentList sl = new StudentList();
			Student testStudent = new Student("TestStudent");
			sl.addStudent(testStudent);
			StudentListManager slm = new StudentListManager(getContext());
			slm.saveStudentList(sl);
			StudentList sl2 = slm.loadStudentList();
			assertTrue("SL2 Size is not consistent",sl2.size() == 1);
			assertTrue("Chosen student doesn't have same name", sl2.chooseStudent().equals(testStudent));
			assertTrue("TestStudent is not in Student List2",sl2.contains(testStudent));
			assertTrue("TestStudent is in Student List",sl.contains(testStudent));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue("IOException Thrown "+e.toString(),false);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assertTrue("ClassNotFoundException Thrown "+e.toString(),false);			
		} catch (EmptyStudentListException e) {
			e.printStackTrace();
			assertTrue("EmptyStudentListException "+e,false);
		}
	}
}

