package ca.softwareprocess.studentpicker;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class StudentList implements Serializable {
	
	/**
	 * StudentList serialization ID
	 */
	private static final long serialVersionUID = 6673446047991058932L;
	protected ArrayList<Student> studentList = null;
	protected transient ArrayList<Listener> listeners = null;
	
	public StudentList() {
		studentList = new ArrayList<Student>();		
		listeners = new ArrayList<Listener>();
	}
	
	private ArrayList<Listener> getListeners() {
		if (listeners == null ) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	public Collection<Student> getStudents() {
		return studentList;		
	}

	public void addStudent(Student testStudent) {
		studentList.add(testStudent);
		notifyListeners();
	}

	private void notifyListeners() {
		for (Listener  listener : getListeners()) {
			listener.update();
		}
	}
	
	public void removeStudent(Student testStudent) {
		studentList.remove(testStudent);
		notifyListeners();
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

	public void addListener(Listener l) {
		getListeners().add(l);
	}

	public void removeListener(Listener l) {
		getListeners().remove(l);
	}
	
}
