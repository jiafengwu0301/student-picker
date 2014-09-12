package ca.softwareprocess.studentpicker;

import java.util.ArrayList;
import java.util.Collection;

public class StudentList {
	
	protected ArrayList<Student> studentList;
	
	public StudentList() {
		studentList = new ArrayList<Student>();		
	}
	
	public Collection<Student> getStudents() {
		return studentList;		
	}

	public void addStudent(Student testStudent) {
		studentList.add(testStudent);
	}

	public void removeStudent(Student testStudent) {
		studentList.remove(testStudent);		
	}

	public Student chooseStudent() throws EmptyStudentListException {
		int size = studentList.size();
		if (size <= 0) {
			throw new EmptyStudentListException();
		}
		int index = (int) (studentList.size() * Math.random());
		return studentList.get(index);
	}

	public int size() {
		return studentList.size();
	}

	public boolean contains(Student testStudent) {
		return studentList.contains(testStudent);
	}

}
